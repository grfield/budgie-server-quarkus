package com.someware.budgie.backend;

import com.someware.budgie.backend.entities.Account;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class AccountService implements AccountServiceApi {
    @Override
    public List<Account> getAccounts() {
        return List.of(Account.builder()
                .name("Barclays")
                .description("Joint family account")
                .type("current")
                .balance(1000.00)
                .build());
    }

    @Override
    public Response createAccount(Account account) {
        account.persist();
        return Response.status(Response.Status.CREATED)
            .entity(account)
            .build();
    }
}
