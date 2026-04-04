package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.model.Model;
import seedu.address.model.application.Application;

/**
 * Displays a summary of the application statistics.
 */
public class SummaryCommand extends Command {

    public static final String COMMAND_WORD = "summary";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows a summary of your applications.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_SUMMARY_MESSAGE = "Opened summary window.";

    private static final Logger logger = LogsCenter.getLogger(SummaryCommand.class);

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        logger.info("Executing SummaryCommand");

        List<Application> applications = model.getAddressBook().getApplicationList();

        long archived = applications.stream()
                .filter(Application::isArchived)
                .count();
        long total = applications.size() - archived;
        long pending = applications.stream()
                .filter(a -> !a.isArchived())
                .filter(a -> a.getStatus().toString().equalsIgnoreCase("Pending"))
                .count();
        long offered = applications.stream()
                .filter(a -> !a.isArchived())
                .filter(a -> a.getStatus().toString().equalsIgnoreCase("Offered"))
                .count();
        long rejected = applications.stream()
                .filter(a -> !a.isArchived())
                .filter(a -> a.getStatus().toString().equalsIgnoreCase("Rejected"))
                .count();

        assert pending + offered + rejected == total
                : "Status counts should sum to total: " + pending + "+" + offered + "+" + rejected + " != " + total;

        logger.fine("Summary computed: total=" + total
                + ", pending=" + pending + ", offered=" + offered + ", rejected=" + rejected
                + ", archived=" + archived);

        String successRate = (offered + rejected) > 0
                ? String.format("%.1f%%", (offered * 100.0) / (offered + rejected))
                : "N/A";

        String summaryText = "Application Summary\n\n"
                + "Total Applications: " + total + "\n"
                + "Pending: " + pending + "\n"
                + "Offered: " + offered + "\n"
                + "Rejected: " + rejected + "\n"
                + "Success Rate: " + successRate + "\n"
                + "\n"
                + "Archived: " + archived + "\n";

        return new CommandResult(summaryText, UiAction.SHOW_SUMMARY);
    }
}
