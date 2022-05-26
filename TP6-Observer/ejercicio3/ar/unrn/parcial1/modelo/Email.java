package ar.unrn.parcial1.modelo;

public class Email {

	private String email;

	public Email(String email) {

		if (!checkEmail(email)) {
			throw new RuntimeException("email debe ser válido");

		}

		this.email = email;
	}

	private boolean checkEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
}
