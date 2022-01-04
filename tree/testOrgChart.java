package tree;

public class testOrgChart {

	public static void main(String[] args) {

		OrgChart chart = new OrgChartImpl();
		// fill the org chart
		Employee e1 = new Employee();
		e1.setName("Jason");
		e1.setId(1);
		e1.setPosition("CIO");

		Employee e2 = new Employee();
		e2.setName("Abigail");
		e2.setId(2);
		e2.setPosition("Supervisor");

		Employee e3 = new Employee();
		e3.setName("Phat");
		e3.setId(3);
		e3.setPosition("Programmer");

		Employee e4 = new Employee();
		e4.setName("Bob");
		e4.setId(4);
		e4.setPosition("Supervisor");

		Employee e5 = new Employee();
		e5.setName("Jon");
		e5.setId(5);
		e5.setPosition("Programmer");

		chart.addRoot(e1);
		chart.addDirectReport(e1, e2);
		chart.addDirectReport(e1, e4);
		chart.addDirectReport(e2, e3);
		chart.addDirectReport(e4, e5);
		// show it depth first
		chart.showOrgChartDepthFirst();
		System.out.println("=================================================================================================");
		// show breadth first
		chart.showOrgChartBreadthFirst();
		System.out.println("=================================================================================================");
		// and remove some people
		chart.removeEmployee(e3);
		// show it depth first
		chart.showOrgChartDepthFirst();
		System.out.println("=================================================================================================");
		// show breadth first
		chart.showOrgChartBreadthFirst();
		System.out.println("=================================================================================================");
	}

}
