package com.icommerce.product.repository.shared;

import com.icommerce.product.service.shared.CommonUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericSpecificationsBuilder<U> {

    private final List<SearchCriteria> params;

    public GenericSpecificationsBuilder() {
        this.params = new ArrayList<>();
    }

    public static <T> Specification<T> build(String searchParams) {
        if (CommonUtils.isNullOrEmpty(searchParams)) {
            return null;
        }

        SearchCriteriaParser parser = new SearchCriteriaParser();
        GenericSpecificationsBuilder<T> specBuilder = new GenericSpecificationsBuilder<>();
        Deque<?> parse_result = parser.parse(searchParams);
        Specification<T> spec = specBuilder.build(parse_result, GenericSearchSpecification<T>::new);
        return spec;
    }

    public Specification<U> build(Deque<?> postFixedExprStack, Function<SearchCriteria, Specification<U>> converter) {

        Deque<Specification<U>> specStack = new LinkedList<>();

        Collections.reverse((List<?>) postFixedExprStack);

        while (!postFixedExprStack.isEmpty()) {
            Object mayBeOperand = postFixedExprStack.pop();

            if (!(mayBeOperand instanceof String)) {
                specStack.push(converter.apply((SearchCriteria) mayBeOperand));
            } else {
                Specification<U> operand1 = specStack.pop();
                Specification<U> operand2 = specStack.pop();
                if (mayBeOperand.equals(SearchOperations.AND_OPERATOR))
                    specStack.push(Specification.where(operand1).and(operand2));
                else if (mayBeOperand.equals(SearchOperations.OR_OPERATOR))
                    specStack.push(Specification.where(operand1).or(operand2));
            }

        }
        return CommonUtils.isNullOrEmpty(specStack) ? null : specStack.pop();

    }
}
