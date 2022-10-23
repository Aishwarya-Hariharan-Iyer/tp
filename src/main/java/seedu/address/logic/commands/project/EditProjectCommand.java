package seedu.address.logic.commands.project;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.ProjectCliSyntax.PREFIX_CLIENT_ID;
import static seedu.address.logic.parser.ProjectCliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.ProjectCliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.ProjectCliSyntax.PREFIX_PROJECT_ID;
import static seedu.address.logic.parser.ProjectCliSyntax.PREFIX_REPOSITORY;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PROJECTS;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Deadline;
import seedu.address.model.Model;
import seedu.address.model.Name;
import seedu.address.model.client.Client;
import seedu.address.model.client.ClientId;
import seedu.address.model.list.NotFoundException;
import seedu.address.model.project.Project;
import seedu.address.model.project.ProjectId;
import seedu.address.model.project.Repository;
import seedu.address.ui.Ui;

/**
 * Edit project command to edit projects
 */
public class EditProjectCommand extends ProjectCommand {

    public static final String COMMAND_FLAG = "-e";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + " " + COMMAND_FLAG
            + ": Edits a project in the address book. "
            + "Parameters: "
            + PREFIX_PROJECT_ID + "PROJECT_ID "
            + PREFIX_NAME + "NAME "
            + PREFIX_CLIENT_ID + "CLIENT_ID "
            + PREFIX_REPOSITORY + "REPOSITORY "
            + PREFIX_DEADLINE + "DEADLINE "
            + "Example: " + COMMAND_WORD + " "
            + COMMAND_FLAG + " "
            + PREFIX_PROJECT_ID + "1 "
            + PREFIX_NAME + "John "
            + PREFIX_CLIENT_ID + "1 "
            + PREFIX_REPOSITORY + "JohnDoe/tp "
            + PREFIX_DEADLINE + "2022-03-05 ";

    public static final String MESSAGE_SUCCESS = "Project %1$s has been edited";
    public static final String MESSAGE_INVALID_CLIENT = "Client does not exist.";

    private final ProjectId projectToEditId;
    private final Name newName;
    private final ClientId newClientId;
    private final Repository newRepository;
    private final Deadline newDeadline;

    /**
     * Creates an EditProjectCommand to edit the specified {@code Project}
     */
    public EditProjectCommand(
            ProjectId projectToEditId, Name newName, ClientId newClientId,
            Repository newRepository, Deadline newDeadline) {
        // Some of these may be NULL, and that is okay.
        this.projectToEditId = projectToEditId;
        this.newName = newName;
        this.newClientId = newClientId;
        this.newRepository = newRepository;
        this.newDeadline = newDeadline;
    }

    @Override
    public CommandResult execute(Model model, Ui ui) throws CommandException {
        ui.showProjects();
        model.updateFilteredProjectList(PREDICATE_SHOW_ALL_PROJECTS);

        Project toEditProject = model.getProjectById(projectToEditId.getIdInt());

        if (newName != null) {
            toEditProject.setName(newName);
        }

        if (newClientId != null) {
            try {
                Client newClient = model.getClientById(newClientId.getIdInt());
                toEditProject.setClient(newClient);
            } catch (NotFoundException e) {
                throw new CommandException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        EditProjectCommand.MESSAGE_INVALID_CLIENT));
            }
        }

        if (newRepository != null) {
            toEditProject.setRepository(newRepository);
        }

        if (newDeadline != null) {
            toEditProject.setDeadline(newDeadline);
        }

        return new CommandResult(String.format(MESSAGE_SUCCESS, toEditProject));
    }
}
