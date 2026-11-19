/*Challenge 7: Template Method Pattern — “Document Generation”
Goal: Use inheritance to control algorithm steps.
Instructions:
• Abstract class: Document
o method: generate() (template method)
o abstract steps: write_header(), write_body(), write_footer()
Derived:
• InvoiceDocument
• ResumeDocument
• ReportDocument
Task:
Implement full document generation through overridden methods.
 */
public class Lab6CH7 {
    public static void main(String[] args) {
        Document invoice = new InvoiceDocument();
        invoice.generate();

        Document resume = new ResumeDocument();
        resume.generate();

        Document report = new ReportDocument();
        report.generate();
    }

    public static abstract class Document {
        public final void generate() {
            write_header();
            write_body();
            write_footer();
        }

        protected abstract void write_header();
        protected abstract void write_body();
        protected abstract void write_footer();
    }

    public static class InvoiceDocument extends Document {
        @Override
        protected void write_header() {
            System.out.println("Invoice Header");
        }

        @Override
        protected void write_body() {
            System.out.println("Invoice Body");
        }

        @Override
        protected void write_footer() {
            System.out.println("Invoice Footer");
        }
    }

    public static class ResumeDocument extends Document {
        @Override
        protected void write_header() {
            System.out.println("Resume Header");
        }

        @Override
        protected void write_body() {
            System.out.println("Resume Body");
        }

        @Override
        protected void write_footer() {
            System.out.println("Resume Footer");
        }
    }

    public static class ReportDocument extends Document {
        @Override
        protected void write_header() {
            System.out.println("Report Header");
        }

        @Override
        protected void write_body() {
            System.out.println("Report Body");
        }

        @Override
        protected void write_footer() {
            System.out.println("Report Footer");
        }
    }
}
