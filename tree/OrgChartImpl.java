package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class OrgChartImpl implements OrgChart {

	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();

	@Override
	public void addRoot(Employee e) {
		if (nodes.isEmpty()) {
			GenericTreeNode<Employee> root = new GenericTreeNode<Employee>(e);
			nodes.add(root);
		}

	}

	@Override
	public void clear() {
		nodes.removeAll(nodes);

	}

	@Override
	public void addDirectReport(Employee manager, Employee newPerson) {
		for (int i = 0; i < nodes.size(); i++) {
			GenericTreeNode<Employee> currentEmployee = nodes.get(i);
			if (currentEmployee.data.equals(manager)) {
				GenericTreeNode<Employee> newE = new GenericTreeNode<Employee>(newPerson);

				currentEmployee.addChild(new GenericTreeNode<Employee>(newPerson));
				nodes.add(newE);
				break;
			}
		}

	}

	@Override
	public void removeEmployee(Employee firedPerson) {

		for (GenericTreeNode<Employee> r : nodes) {
			if (r.data.equals(firedPerson)) {
				r.removeChild(firedPerson);
				nodes.remove(r);
			}
		}

	}

	@Override
	public void showOrgChartDepthFirst() {

		Stack<GenericTreeNode<Employee>> stk = new Stack<GenericTreeNode<Employee>>();
		stk.push(nodes.get(0));

		while (!stk.empty()) {
			GenericTreeNode<Employee> n = stk.pop();
			for (GenericTreeNode<Employee> e : n.children) {
				stk.push(e);
			}
			System.out.print(n.data + "\n");
		}

	}

	@Override
	public void showOrgChartBreadthFirst() {

		Queue<GenericTreeNode<Employee>> q = new LinkedList<GenericTreeNode<Employee>>();
		q.add(nodes.get(0));

		while (!q.isEmpty()) {
			GenericTreeNode<Employee> head = q.poll();
			for (GenericTreeNode<Employee> e : head.children) {
				q.add(e);
			}
			System.out.print(head.data + "\n");
		}
	}
}
