package com.someware.budgie.backend;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Path("/accounts")
@OpenAPIDefinition(
    info = @Info(
        title = "Accounts API",
        version = "1.0",
        description = "API for managing financial accounts"
    )
)
public class AccountsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all accounts", description = "Returns a list of all financial accounts")
    @APIResponse(
        responseCode = "200",
        description = "List of accounts",
        content = @Content(
            mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(
                examples = {
                    "[{'id': 1, 'name': 'Barclays', 'type': 'credit', 'balance': 1000.00}]"
                }
            )
        )
    )
    public String getAccounts() {
        return "[{ 'id': 1, 'name': 'Barclays', 'type': 'credit', 'balance': 1000 }]";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Create a new account", description = "Creates a new financial account")
    @APIResponse(
        responseCode = "200",
        description = "Account created successfully",
        content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public String createAccount(String account) {
        return account;
    }

}
