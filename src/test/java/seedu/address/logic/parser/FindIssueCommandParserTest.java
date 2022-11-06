package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.client.FindClientCommand;
import seedu.address.logic.commands.issue.FindIssueCommand;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

public class FindIssueCommandParserTest {
    private IssueCommandParser parser = new IssueCommandParser();
    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "-f", "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                FindIssueCommand.MESSAGE_FIND_ISSUE_USAGE));
    }

    @Test
    public void parse_argsWithNoPefix_throwsParseException() {
        assertParseFailure(parser, "-f", "abcd", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                FindIssueCommand.MESSAGE_FIND_ISSUE_USAGE));
    }


}
