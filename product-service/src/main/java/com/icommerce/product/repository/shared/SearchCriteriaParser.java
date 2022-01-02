package com.icommerce.product.repository.shared;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchCriteriaParser {

    private static final Map<String, Operator> operators;
    private static final Pattern SpecCriteriaRegex =
      Pattern.compile("^(\\w+?)(" + String.join("|", SearchOperations.SIMPLE_OPERATION_SET)
              + ")(\\p{Punct}?)([\\w-]+?)(\\p{Punct}?)$",
          Pattern.UNICODE_CHARACTER_CLASS);

    private enum Operator {
        OR(1), AND(2);

        final int precedence;

        Operator(int p) {
            precedence = p;
        }
    }

    static { 
        operators = Map.of("AND", Operator.AND, "OR", Operator.OR);
    }

    private static boolean isHigherPrecedenceOperator(String currOp, String prevOp) {
        return (operators.containsKey(prevOp) && operators.get(prevOp).precedence >= operators.get(currOp).precedence);
    }

    public Deque<?> parse(String specCriteria) {
        Deque<Object> output = new LinkedList<>();
        Deque<String> stack = new LinkedList<>();

        // Remove spaces.
        specCriteria = specCriteria.replaceAll("(?i)((\\s+)(?!(and|or)))", "");
        // Add spaces.
        specCriteria = specCriteria.replaceAll("(?i)((\\()|(\\))|(\\s(or|and)))", " $1 ");
        // Remove first and last space.
        specCriteria = specCriteria.trim();
        //searchParam = searchParam.replaceAll("\\s+", " ");
        Arrays.stream(specCriteria.split("\\s+")).forEach(token -> {
            if (operators.containsKey(token.toUpperCase())) {
            	token = token.toUpperCase();
                while (!stack.isEmpty() && isHigherPrecedenceOperator(token, stack.peek()))
                    output.push(stack.pop().equalsIgnoreCase(SearchOperations.OR_OPERATOR) ? SearchOperations.OR_OPERATOR : SearchOperations.AND_OPERATOR);
                stack.push(token.equalsIgnoreCase(SearchOperations.OR_OPERATOR) ? SearchOperations.OR_OPERATOR : SearchOperations.AND_OPERATOR);
            } else if (token.equals(SearchOperations.LEFT_PARENTHESES)) {
                stack.push(SearchOperations.LEFT_PARENTHESES);
            } else if (token.equals(SearchOperations.RIGHT_PARENTHESES)) {
                while (!stack.peek().equals(SearchOperations.LEFT_PARENTHESES))
                    output.push(stack.pop());
                stack.pop();
            } else {

                Matcher matcher = SpecCriteriaRegex.matcher(token);
                while (matcher.find()) {
                    output.push(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4).replace("_", " "), matcher.group(5)));
                }
            }
        });

        while (!stack.isEmpty())
            output.push(stack.pop());

        return output;
    }

}
