package com.someware.budgie.backend;

import com.someware.budgie.backend.entities.Account;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/accounts")
@Tag(name = "Account Management API", description = "Financial accounts management")
public interface AccountServiceApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all accounts", description = "Returns a list of all financial accounts")
    @APIResponse(
        responseCode = "200",
        description = "List of accounts",
        content = @Content(
            mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(
                examples = {"""
                    [
                      {
                        "name": "Barclays",
                        "description": "Joint family account",
                        "type": "credit",
                        "balance": 1000.00
                      }
                    ]
                    """
                }
            )
        )
    )
    List<Account> getAccounts();

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Create a new account", description = "Creates a new financial account")
    @RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON,
        schema = @Schema(implementation = Account.class),
        examples = @ExampleObject(
            name = "default",
            summary = "Example account creation request",
            value = """
                {
                  "name": "Barclays",
                  "type": "Current",
                  "balance": 1000.00,
                  "description": "Primary account for daily expenses"
                }
                """
        )))
    @APIResponse(
        responseCode = "201",
        description = "Account created successfully",
        content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    Response createAccount(Account account);

}
