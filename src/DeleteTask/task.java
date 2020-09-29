package DeleteTask;

public class task {
	
	private int tid;
	private String taskname;
	private String taskdesc;
	private String status;
	private String email;
	public task(int tid, String taskname, String taskdesc, String status, String email) {
		super();
		this.tid = tid;
		this.taskname = taskname;
		this.taskdesc = taskdesc;
		this.status = status;
		this.email = email;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getTaskdesc() {
		return taskdesc;
	}
	public void setTaskdesc(String taskdesc) {
		this.taskdesc = taskdesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
