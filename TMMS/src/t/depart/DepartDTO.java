package t.depart;

import java.io.Serializable;

public class DepartDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int did;
	private String dname;

	public DepartDTO() {
		// TODO Auto-generated constructor stub
	}

	public DepartDTO(int did,String dname) {
		this.dname = dname;
		this.did = did;
	}


	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + did;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartDTO other = (DepartDTO) obj;
		if (did != other.did)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DepartDTO [dname=" + dname + ", did=" + did + "]";
	}

	
}
