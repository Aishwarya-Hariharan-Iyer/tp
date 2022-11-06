package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.client.FindClientCommand;
import seedu.address.logic.commands.project.FindProjectCommand;
import seedu.address.logic.parser.predicates.ClientContainsKeywordsPredicate;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

public class FindClientCommandParserTest {

    private ClientCommandParser parser = new ClientCommandParser();
    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "-f", "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                FindClientCommand.MESSAGE_FIND_CLIENT_USAGE));
    }

    @Test
    public void parse_argsWithNoPefix_throwsParseException() {
        assertParseFailure(parser, "-f", "abcd", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                FindClientCommand.MESSAGE_FIND_CLIENT_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {

        //some valid input lists
        List<String> nameList= Arrays.asList("Harry", "Jaime");
        List<String> nameEmptyList= Arrays.asList("");
        List<String> mobileList= Arrays.asList("103835180", "1234", "3761718301");
        List<String> mobileEmptyList= Arrays.asList("");
        List<String> emailList= Arrays.asList("lucy@yahoo.co.in", "potter@reddit.com-sg");
        List<String> emailEmptyList= Arrays.asList("");
        List<String> clientIdList = Arrays.asList("1", "2");
        List<String> phoneEmptyList= Arrays.asList("");

        // no leading and trailing whitespaces
        FindClientCommand expectedFindCommand =
                new FindClientCommand(new ClientContainsKeywordsPredicate(nameList, emailList,
                        mobileList, clientIdList));
        assertParseSuccess(parser, "-f",
                " n/Harry Jaime m/103835180 e/lucy@yahoo.co.in potter@reddit.com-sg c/1 2",
                expectedFindCommand);
    }


}
