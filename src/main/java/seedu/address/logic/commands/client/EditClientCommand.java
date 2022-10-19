package seedu.address.logic.commands.client;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.ProjectCliSyntax;
import seedu.address.model.Deadline;
import seedu.address.model.Model;
import seedu.address.model.Name;
import seedu.address.model.client.Client;
import seedu.address.model.client.ClientEmail;
import seedu.address.model.client.ClientId;
import seedu.address.model.client.ClientPhone;
import seedu.address.model.issue.Description;
import seedu.address.model.issue.Issue;
import seedu.address.model.issue.IssueId;
import seedu.address.model.issue.Priority;
import seedu.address.model.project.Project;
import seedu.address.ui.Ui;

import java.util.ArrayList;
import java.util.TreeSet;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.ClientCliSyntax.PREFIX_CLIENT_EMAIL;
import static seedu.address.logic.parser.ClientCliSyntax.PREFIX_CLIENT_NAME;
import static seedu.address.logic.parser.ClientCliSyntax.PREFIX_CLIENT_PHONE;
import static seedu.address.logic.parser.IssueCliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.IssueCliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.IssueCliSyntax.PREFIX_ISSUE_ID;
import static seedu.address.logic.parser.IssueCliSyntax.PREFIX_PRIORITY;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CLIENTS;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_ISSUES;

/**
 * Edits the details of an existing client in the address book.
 */
public class EditClientCommand extends ClientCommand {

    public static final String COMMAND_FLAG = "-e";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits a client in the address book. "
            + "Parameters: "
            + PREFIX_CLIENT_NAME + "NAME "
            + PREFIX_CLIENT_PHONE + "PHONE "
            + PREFIX_CLIENT_EMAIL + "EMAIL "
            + "Example: " + COMMAND_WORD + " "
            + COMMAND_FLAG + " "
            + PREFIX_CLIENT_NAME + "Harry "
            + PREFIX_CLIENT_PHONE + "12346547 "
            + PREFIX_CLIENT_EMAIL + "hp123@gmail.com ";

    public static final String MESSAGE_SUCCESS = "Client %1$s has been edited";

    private final Name newName;
    private final ClientEmail newEmail;
    private final ClientPhone newPhone;
    private final ClientId clientId;

    /**
     * Creates an EditClientCommand to edit the specified {@code Client}
     */
    public EditClientCommand(Name newName, ClientEmail newEmail, ClientPhone newPhone, ClientId clientId) {
        requireAllNonNull(newName, newEmail, newPhone);
       this.newName = newName;
       this.newEmail = newEmail;
       this.newPhone = newPhone;
       this.clientId = clientId;
    }

    @Override
    public CommandResult execute(Model model, Ui ui) throws CommandException {
        ui.showClients();
        Client toEditClient = model.getClientById(clientId.getIdInt());

        if (newName != null) {
            toEditClient.setClientName(newName);
        }

        if (newPhone != null) {
            toEditClient.setClientEmail(newEmail);
        }

        if (newPhone != null) {
            toEditClient.setClientPhone(newPhone);
        }

        model.updateFilteredClientList(PREDICATE_SHOW_ALL_CLIENTS);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toEditClient));
    }
}
