import java.util.Scanner;

class Login {
	String username = "admin";
	int password = 12345;

	String enterUsername;
	int enterPassword;

	Login() {
		// nothing required here
	}

	void setEnterUsername(String enterUsername) {
		this.enterUsername = enterUsername;
	}

	void setEnterPassword(int enterPassword) {
		this.enterPassword = enterPassword;
	}

	void validateLogin() throws InvalidUsernameException, InvalidPasswordException {

		if (enterUsername == null) {
			throw new InvalidUsernameException();
		}

		if (!enterUsername.equals(username)) {
			throw new InvalidUsernameException();
		}

		if (enterPassword != password) {
			throw new InvalidPasswordException();
		}
	}
}

class testLogin {
	public static void main(String[] args) {

		Login l1 = new Login();
		Scanner sc = new Scanner(System.in);
		int attempts = 0;

		while (attempts < 3) {

			System.out.print("Enter username: ");
			String user = sc.nextLine();

			System.out.print("Enter password: ");
			int pass = sc.nextInt();
			sc.nextLine(); // clear buffer

			// IMPORTANT: SET INPUT VALUES INTO THE OBJECT
			l1.setEnterUsername(user);
			l1.setEnterPassword(pass);

			try {
				l1.validateLogin();
				break; // success
			} catch (InvalidUsernameException | InvalidPasswordException e) {
				System.out.println(e);
				attempts++;
				System.out.println("Attempts left: " + (3 - attempts));
			}
		}

		if (attempts < 3) {
			System.out.println("Login Successful!");
		} else {
			System.out.println("Account Blocked!! Too many attempts.");
		}
	}
}
