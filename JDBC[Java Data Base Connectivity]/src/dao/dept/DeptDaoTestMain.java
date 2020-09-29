package dao.dept;

import java.util.ArrayList;

public class DeptDaoTestMain {

	public static void main(String[] args) throws Exception {
		DeptDao deptDao=new DeptDaoImpl();
		deptDao.insert(new Dept(50,"TEACHER","SEOUL"));
		
		
		Dept d = deptDao.selectByNo(20);
		System.out.println(d);
		
		
		ArrayList<Dept> dd = deptDao.selectByAll();
		for (Dept dept : dd) {
			System.out.println(dept);
		}
	}

}
