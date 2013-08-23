public class Branch {
	public String name;
	public Commit head;

	public Branch(String name, Commit initialHead) {
		this.head = initialHead;
		this.name = name;
	}


	@Override
	public String toString() {
		String output  = "HEAD";

		if (head == null) {
			return output;
		}

		return String.format("HEAD=>%s", stringifyCommit(head));
	}

	private String stringifyCommit(Commit node) {
		if (node == null) {
			return "";
		}

		return String.format("%s%s%s", node.getValue().toString(),
			node.getParents().iterator().hasNext() ? "-->" : "",
		   	stringifyCommit(node.getParents().iterator().hasNext() ? node.getParents().iterator().next() : null));
	}


	public void commit(Commit node) {
		if (head != null) {
			node.addParent(head);
		}

		head = node;
	}
}
