package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.project.FindProjectCommand;
import seedu.address.logic.parser.predicates.ProjectContainsKeywordsPredicate;
import seedu.address.model.Name;
import seedu.address.model.project.Repository;


/**
 * Represents the tests for parsing the FindProjectCommand.
 */
public class FindProjectCommandParserTest {
    private ProjectCommandParser parser = new ProjectCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        //no prefix arguments given
        assertParseFailure(parser, "-f", "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                FindProjectCommand.MESSAGE_FIND_PROJECT_USAGE));
    }

    @Test
    public void parse_argsWithNoPrefix_throwsParseException() {
        //arguments are not suited to the command format
        assertParseFailure(parser, "-f", "abcd", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                FindProjectCommand.MESSAGE_FIND_PROJECT_USAGE));
    }

    @Test
    public void parse_validMultiPrefixWithNoRepetitionArgs_returnsFindCommand() {

        //all prefixes are given with valid keywords
        List<String> projectName = Arrays.asList("DevEnable");
        List<String> repository = Arrays.asList("tp/F-13");
        List<String> projectId = Arrays.asList("3");
        List<String> clientLabel = Arrays.asList("Sally");
        List<String> clientId = Arrays.asList("1");



        FindProjectCommand expectedFindCommand =
                new FindProjectCommand(new ProjectContainsKeywordsPredicate(projectName, repository, clientLabel,
                        clientId, projectId));
        assertParseSuccess(parser, "-f",
                " n/DevEnable r/tp/F-13 p/3 c/1 l/Sally",
                expectedFindCommand);
    }

    @Test
    public void parse_validMultiPrefixWithRepetitionArgs_returnsFindCommand() {

        //multiple valid prefix-keywords pairs are found in order
        List<String> projectName = Arrays.asList("DevEnable", "AB3");
        List<String> repository = Arrays.asList("tp/F-13", "tp/AB3");
        List<String> projectId = Arrays.asList("3, 7");
        List<String> clientLabel = Arrays.asList("Sally James", "Harry Potter");
        List<String> clientId = Arrays.asList("1, 4");

        FindProjectCommand expectedFindCommand =
                new FindProjectCommand(new ProjectContainsKeywordsPredicate(projectName, repository, clientLabel,
                        clientId, projectId));
        assertParseSuccess(parser, "-f",
                " n/DevEnable n/AB3 r/tp/F-13 r/tp/AB3 p/3 p/7 c/1 c/4 l/Sally James l/Harry Potter",
                expectedFindCommand);
    }

    @Test
    public void parse_validMultiPrefixInMixedOrder_returnsFindCommand() {

        //multiple valid prefix-keywords pairs are found shuffled
        List<String> projectName = Arrays.asList("DevEnable");
        List<String> repository = Arrays.asList("tp/F-13", "tp/AB3");
        List<String> projectId = Arrays.asList("3, 7");
        List<String> clientLabel = Arrays.asList("Sally James", "Harry Potter");
        List<String> clientId = Arrays.asList("1, 4");

        FindProjectCommand expectedFindCommand =
                new FindProjectCommand(new ProjectContainsKeywordsPredicate(projectName, repository, clientLabel,
                        clientId, projectId));
        assertParseSuccess(parser, "-f",
                " n/DevEnable c/1 r/tp/F-13 p/3 r/tp/AB3 l/Sally James n/AB3 p/7 c/4 l/Harry Potter",
                expectedFindCommand);
    }

    @Test
    public void parse_invalidMultiPrefix_throwsException() {

        //invalid keywords given for the prefixes
        assertParseFailure(parser, "-f", " n/invalid@projectname", Name.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "-f", " r/tp/ab3/invalidRepo", Repository.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "-f", " p/0", ParserUtil.MESSAGE_INVALID_INDEX);
        assertParseFailure(parser, "-f", " p/-1", ParserUtil.MESSAGE_INVALID_INDEX);
        assertParseFailure(parser, "-f", " l/client-label-invalid", Name.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "-f", " c/0", ParserUtil.MESSAGE_INVALID_INDEX);
        assertParseFailure(parser, "-f", " c/-1", ParserUtil.MESSAGE_INVALID_INDEX);
    }

    @Test
    public void parse_emptyMultiPrefix_throwsException() {

        //empty keywords given for the prefixes
        assertParseFailure(parser, "-f", " n/", Name.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "-f", " r/", Repository.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "-f", " p/", ParserUtil.MESSAGE_INVALID_INDEX);
        assertParseFailure(parser, "-f", " l/", Name.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "-f", " c/", ParserUtil.MESSAGE_INVALID_INDEX);
    }
}