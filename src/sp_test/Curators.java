package sp_test;

import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import sp_entities.Semester;
import sp_entities.Semesters;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Curators {
	@XmlJavaTypeAdapter(CuratorsMapAdapter.class)
	@XmlElement(name="curator")
	private Map<Integer, List<CuratorWork>> curators;
	
	public Curators() {
		curators = new HashMap<>();
	}
	
	public void addCurator(int idCur, List<CuratorWork> works) {
		curators.put(idCur, works);
	}
	
	public Semesters getCuratorSemesters(int idCur) {
		List<CuratorWork> works = curators.get(idCur);
		if(works == null) return null;
		List<Semester> sems = new ArrayList<>();
		for(CuratorWork w : works) {
			sems.add(w.sem);
		}
		return new Semesters(sems);
	}
	
	public String getCuratorGroup(int idCur, Semester semester) {
		List<CuratorWork> works = curators.get(idCur);
		if(works == null) return null;
		for(CuratorWork w : works) {
			if(w.sem.equals(semester)) {
				return w.group;
			}
		}
		return "";
	}
	
	//TODO delete
	public void tempInit() {
		Semester sem1_2012 = new Semester((byte)1, 2012);
		Semester sem2_2012 = new Semester((byte)2, 2012);
		Semester sem1_2013 = new Semester((byte)1, 2013);
		Semester sem2_2013 = new Semester((byte)2, 2013);
		Semester sem1_2014 = new Semester((byte)1, 2014);
		Semester sem2_2014 = new Semester((byte)2, 2014);
		
		List<CuratorWork> works= new ArrayList<>();
		works.add(new CuratorWork(sem1_2012, "��-111"));
		works.add(new CuratorWork(sem2_2012, "��-111"));
		works.add(new CuratorWork(sem1_2013, "��-111"));
		works.add(new CuratorWork(sem2_2013, "��-111"));
		addCurator(3, works);
		
		works= new ArrayList<>();
		works.add(new CuratorWork(sem1_2014, "��-111"));
		works.add(new CuratorWork(sem2_2014, "��-111"));
		addCurator(4, works);
	}
	
	//TODO delete
	public void print() {
		System.out.println("================\nCurators");
		for (Map.Entry<Integer, List<CuratorWork>> cur: curators.entrySet())
		{
			System.out.println("idCurator: " + cur.getKey());
		    for(CuratorWork w : cur.getValue()) {
		    	w.print();
		    }
		}
	}
}
