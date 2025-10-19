package estu.ceng.MavenArgs4JLab;

import org.kohsuke.args4j.Option;

import org.kohsuke.args4j.CmdLineParser;

import org.kohsuke.args4j.CmdLineException;
class CalculatorApp {



    @Option (name="--num1", aliases="--firstNumber", usage="It takes number 1", required=true)

    private double num1;


    @Option (name="--num2", aliases="--secondNumber", usage="It takes number 1", required=true)

    private double num2;



    @Option (name="--op", aliases="--operation", usage="It takes operation", required=true)

    private String operation;



    @Option (name="--round", usage="For rounding")

    private boolean round; // A flag for rounding result



    public static void main(String[] args) {
        new CalculatorApp().doMain(args);

    }



    public void doMain(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);

            double result = 0;
            switch (operation) {
                case "add":
                    result = num1 + num2;
                    break;
                case "subb":
                    result = num1 - num2;
                    break;
                case "mul":
                    result = num1 * num2;
                    break;
                case "div":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero!");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Invalid operation. Use add, subb, mul or div");
                    return;
            }

            if (round) {
                result = Math.round(result);
            }

            System.out.println("Result: " + result);

        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("Usage: java CalculatorApp -num1 <number> -num2 <number> -opp <operation> [-round]");
            parser.printUsage(System.err);
        }
    }
}

