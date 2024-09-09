package demo.example.model;

public class LoginResponse {
    private boolean existsByAccount;
    private boolean existsByPassword;
    private boolean isAdmin;

    
    
    public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoginResponse(boolean existsByAccount, boolean existsByPassword, boolean isAdmin) {
        this.existsByAccount = existsByAccount;
        this.existsByPassword = existsByPassword;
        this.isAdmin = isAdmin;
    }
	

	public boolean isExistsByAccount() {
		return existsByAccount;
	}

	public void setExistsByAccount(boolean existsByAccount) {
		this.existsByAccount = existsByAccount;
	}

	public boolean isExistsByPassword() {
		return existsByPassword;
	}

	public void setExistsByPassword(boolean existsByPassword) {
		this.existsByPassword = existsByPassword;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
    
    
}
