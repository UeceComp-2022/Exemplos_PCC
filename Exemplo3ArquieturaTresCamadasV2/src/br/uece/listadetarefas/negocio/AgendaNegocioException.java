package br.uece.listadetarefas.negocio;

public class AgendaNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AgendaNegocioException() {
	}

	public AgendaNegocioException(String message) {
		super(message);
	}

	public AgendaNegocioException(Throwable cause) {
		super(cause);
	}

	public AgendaNegocioException(String message, Throwable cause) {
		super(message, cause);
	}

	public AgendaNegocioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
