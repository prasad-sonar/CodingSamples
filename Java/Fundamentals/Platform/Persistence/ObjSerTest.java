import hr.*;
import java.io.*;

class ObjSerTest {

	public static void main(String[] args) throws Exception{
		if(args.length > 0) {
			Department dept = new Department();
			dept.setTitle(args[0]);
			dept.addEmployee(3, 34000);
			dept.addEmployee(5, 56000);
			dept.addEmployee(7, 78000);
			dept.addEmployee(6, 65000);
			dept.addEmployee(4, 43000);
			try(var output = new ObjectOutputStream(new FileOutputStream("dept.dat"))){
				output.writeObject(dept);
			}
		}else{
			try(var input = new ObjectInputStream(new FileInputStream("dept.dat"))){
				var dept = (Department)input.readObject();
				System.out.printf("Employees in %s department%n", dept.getTitle());
				for(var emp : dept.getEmployees())
					System.out.println(emp);
			}
		}
	}
}


