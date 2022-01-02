package com.icommerce.product.repository.shared;

public enum SortOperation {

    ASC("asc"), DESC("desc");
	
	private String sort;

    public static SortOperation getOperation(String sort) {
        switch (sort) {
            case "asc":
            case " ":
                return ASC;
            case "desc":
                return DESC;
            default:
                return null;
        }
    }
    
    SortOperation(String sortcode) {
    	this.setSort(sortcode);
    }

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}
