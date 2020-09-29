package dao.emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpDaoTestMain {

	public static void main(String[] args)throws Exception {
		EmpDao empDao=new EmpDaoImpl();
		Map<String, Object> rowMap=
				empDao.findEmpnoWithDept(7788);
		if(rowMap.size()>0) {
			System.out.println(
					rowMap.get("EMPNO")+"\t"+
					rowMap.get("ENAME")+"\t"+
					rowMap.get("JOB")+"\t"+
					rowMap.get("DNAME")+"\t"+
					rowMap.get("LOC")
					);
			
		}
	
		ArrayList<HashMap> rowMapList=empDao.findEmpsWithDept();
		
		for (HashMap rowMap2 : rowMapList) {
			System.out.println(
					rowMap2.get("EMPNO")+"\t"+
					rowMap2.get("ENAME")+"\t"+
					rowMap2.get("JOB")+"\t"+
					rowMap2.get("DNAME")+"\t"+
					rowMap2.get("LOC")
					);
		}
		
	}

}
