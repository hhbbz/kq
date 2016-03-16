package aode.kq.been;

import java.util.List;

public class AjaxResult<T> {

	private boolean success;
	private String msg;
	//以下两个参数在store里用到
	private boolean hasError;
	private String error;
	
	private T obj;
	
	
	private List<T>  list;
	
	
	
	
	public List<T> getList() {
		return list;
	}




	public void setList(List<T> list) {
		this.list = list;
	}




	public AjaxResult(){
		
	}
	

	
	
	public T getObj() {
		return obj;
	}




	public void setObj(T obj) {
		this.obj = obj;
	}


	public AjaxResult(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}


	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isHasError() {
		return hasError;
	}
	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}


}
