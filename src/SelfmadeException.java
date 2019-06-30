public class SelfmadeException {
    public void run() {
        CheckingAccount account = new CheckingAccount(1000, 2000);
        try {
            account.withdraw(2000);
        } catch (Account.OverdraftException e) {
            e.printStackTrace();
        }
    }

    class Account {
        protected double balance;

        public Account(double init) {
            this.balance = init;
        }

        public double getBalance() {
            return this.balance;
        }

        public void deposit(double amt) {
            this.balance += amt;
        }

        public void withdraw(double amt) throws OverdraftException {
            this.balance -= amt;
            if (this.balance < 0)
                throw new OverdraftException("The deficit of this account is ", this.balance);
        }

        class OverdraftException extends Exception {
            private double deficit;

            public OverdraftException(String message, double deficit) {
                System.out.println(message + deficit);
            }

            public double getDeficit() {
                return this.deficit;
            }
        }
    }

    class CheckingAccount extends Account{
        private double overdraftProtection;

        public CheckingAccount(double balance) {
            super(balance);
        }

        public CheckingAccount(double balance, double protect) {
            super(balance);
            this.overdraftProtection = protect;
        }

        public void withdraw (double amt) throws OverdraftException {
            if (amt <= this.balance) {
                this.balance -= amt;
            }
            else{
                if (amt <= (this.balance + this.overdraftProtection)) {
                    this.overdraftProtection -= amt - this.balance;
                    this.balance = 0;
                }
                else {
                    throw new OverdraftException("Overdraft number is ", amt - (this.balance + this.overdraftProtection));
                }
            }
        }
    }
}
