package quetzal.registros.util;

public class ResponseApi<T> {

	private String mensaje;

	private String estatus;

	private T response;

	public ResponseApi() {
		super();
	}

	public ResponseApi(String mensaje, String estatus, T response) {
		super();
		this.mensaje = mensaje;
		this.estatus = estatus;
		this.response = response;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}
}
