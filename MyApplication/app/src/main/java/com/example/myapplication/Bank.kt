package com.example.myapplication

class Bank {
    var clients = mutableListOf<User>()
    var accounts = mutableListOf<BankAccount>()

    fun addNewAccount(account: BankAccount) {
        accounts.add(account)
    }

    fun registerNewUser(user: User) {
        clients.add(user)
    }

    fun filterAccount(accountID: String): BankAccount? {
        for (account in accounts) {
            if (account.accountID == accountID)
                return account
        }
        return null
    }

}