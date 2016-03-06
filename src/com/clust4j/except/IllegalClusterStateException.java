package com.clust4j.except;

public class IllegalClusterStateException extends IllegalStateException {

	private static final long serialVersionUID = -2379108879459786857L;

	public IllegalClusterStateException() {
		super();
	}
	
	public IllegalClusterStateException(final String msg) {
		super(msg);
	}
	
	public IllegalClusterStateException(final Throwable thrown) {
		super(thrown);
	}
	
	public IllegalClusterStateException(final String msg, final Throwable thrown) {
		super(msg, thrown);
	}
}