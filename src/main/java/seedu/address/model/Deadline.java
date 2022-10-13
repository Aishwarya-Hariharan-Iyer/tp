package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline.
 */
public class Deadline {

    /**
     * Represents an empty deadline.
     */
    public static class EmptyDeadline extends Deadline {
        public static final Deadline EMPTY_DEADLINE = new EmptyDeadline();

        private EmptyDeadline() {
            super("0001-01-01");
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public String uiRepresentation() {
            return "No Deadline Set";
        }
    }

    public static final String MESSAGE_CONSTRAINTS =
            "Deadlines should be entered in yyyy-mm-dd date format";

    /*
     * The date must be entered in yyyy-mm-dd or yyyy-m-d
     */
    public static final String VALIDATION_REGEX = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";

    private LocalDate deadline;

    /**
     * Constructs a  Deadline.
     *
     * @param deadline A valid  deadline.
     */
    public Deadline(String deadline) {
        requireNonNull(deadline);
        checkArgument(isValidDeadline(deadline), MESSAGE_CONSTRAINTS);
        this.deadline = LocalDate.parse(deadline);
    }

    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns true if a given string is a valid deadline.
     */
    public static boolean isValidDeadline(String deadline) {
        return deadline.matches(VALIDATION_REGEX);
    }

    public String getFormattedDeadline() {
        return deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    public String uiRepresentation() {
        return deadline.toString();
    }

    @Override
    public String toString() {
        return deadline.toString();
    }
}
