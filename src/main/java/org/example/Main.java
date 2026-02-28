package org.example;

import org.example.entity.Employee;
import org.example.entity.Project;
import org.example.entity.Team;
import org.example.entity.Workstation;
import org.example.service.EmployeeService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        Employee employee = new Employee();
        employee.setName("Pavan");
        employee.setTechnology("Spring Boot");

        Workstation workstation = new Workstation();
        workstation.setDeskNumber("A-1");
        workstation.setPcSerialNumber("MAC-01-2043");
        employee.setWorkstation(workstation);

        Project project1 = new Project();
        project1.setProjectName("POS");
        project1.setClientName("American Express");
        project1.setDeadline("28/04/2026");

        Project project2 = new Project();
        project2.setProjectName("In house project");
        project2.setClientName("JP Morgan");
        project2.setDeadline("31/04/2026");

        employee.addProject(project1);
        employee.addProject(project2);

        // Teams
        Team backend = new Team();
        backend.setTeamName("Backend Team");
        backend.setDepartment("Software");

        Team frontend = new Team();
        frontend.setTeamName("Frontend Team");
        frontend.setDepartment("Software");

        employee.addTeam(backend);
        employee.addTeam(frontend);

        service.addEmployee(employee);

        Optional<Employee> retrieved = service.fetchEmployee(1);
        retrieved.ifPresent((emp) -> {
            System.out.println(emp);
            System.out.println(emp.getWorkstation());
            System.out.println(emp.getProjects());
            System.out.println(emp.getTeams());
        });

        retrieved.ifPresent(emp -> {

            Workstation station = emp.getWorkstation();
            station.setDeskNumber("A-5");
            station.setPcSerialNumber("MAC-09-2398");

            Project project = new Project();
            project.setProjectName("RCPOS");
            project.setClientName("Reliance Corporation");
            project.setDeadline("01/01/2027");

            emp.addProject(project);

            service.updateEmployee(emp);
        });

//        retrieved.ifPresent(service::deleteEmployee);
    }
}