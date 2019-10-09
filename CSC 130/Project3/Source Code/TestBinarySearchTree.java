/**
 * An example of how to test your binary search tree. You should use this as
 * inspiration for your unit tests.
 */
public class TestBinarySearchTree {
    public static void main(String[] args) {
        boolean dumpall = false, notest = false;

        if (args.length > 1
                || (args.length == 1 && args[0].compareTo("dump") != 0 && args[0]
                                                                               .compareTo("notest") != 0)) {
            System.err.println("Arguments: [dump] to dump all output");
            System.err.println("           [notest] to skip tests");
            System.err.println("No arguments justs tests output");
            return;
        }

        if (args.length == 1) {
            dumpall = true;
            if (args[0].compareTo("notest") == 0)
                notest = true;
        }

        String[][] tests = {
                { "g", "h", "a", "b", "a", "h", "j", "e", "e", "f" },
                { "5", "3", "1", "2", "7", "6", "0", "8", "9", "4", "3", "5",
                    "0", "9" }, {} };

        String[][] expected = {
                {
                    "([g,1] . .)",
                    "([g,1] . ([h,1] . .))",
                    "([g,1] ([a,1] . .) ([h,1] . .))",
                    "([g,1] ([a,1] . ([b,1] . .)) ([h,1] . .))",
                    "([g,1] ([a,2] . ([b,1] . .)) ([h,1] . .))",
                    "([g,1] ([a,2] . ([b,1] . .)) ([h,2] . .))",
                    "([g,1] ([a,2] . ([b,1] . .)) ([h,2] . ([j,1] . .)))",
                    "([g,1] ([a,2] . ([b,1] . ([e,1] . .))) ([h,2] . ([j,1] . .)))",
                    "([g,1] ([a,2] . ([b,1] . ([e,2] . .))) ([h,2] . ([j,1] . .)))",
                    "([g,1] ([a,2] . ([b,1] . ([e,2] . ([f,1] . .)))) ([h,2] . ([j,1] . .)))",
                "a,2 b,1 e,2 f,1 g,1 h,2 j,1 " },
                {
                    "([5,1] . .)",
                    "([5,1] ([3,1] . .) .)",
                    "([5,1] ([3,1] ([1,1] . .) .) .)",
                    "([5,1] ([3,1] ([1,1] . ([2,1] . .)) .) .)",
                    "([5,1] ([3,1] ([1,1] . ([2,1] . .)) .) ([7,1] . .))",
                    "([5,1] ([3,1] ([1,1] . ([2,1] . .)) .) ([7,1] ([6,1] . .) .))",
                    "([5,1] ([3,1] ([1,1] ([0,1] . .) ([2,1] . .)) .) ([7,1] ([6,1] . .) .))",
                    "([5,1] ([3,1] ([1,1] ([0,1] . .) ([2,1] . .)) .) ([7,1] ([6,1] . .) ([8,1] . .)))",
                    "([5,1] ([3,1] ([1,1] ([0,1] . .) ([2,1] . .)) .) ([7,1] ([6,1] . .) ([8,1] . ([9,1] . .))))",
                    "([5,1] ([3,1] ([1,1] ([0,1] . .) ([2,1] . .)) ([4,1] . .)) ([7,1] ([6,1] . .) ([8,1] . ([9,1] . .))))",
                    "([5,1] ([3,2] ([1,1] ([0,1] . .) ([2,1] . .)) ([4,1] . .)) ([7,1] ([6,1] . .) ([8,1] . ([9,1] . .))))",
                    "([5,2] ([3,2] ([1,1] ([0,1] . .) ([2,1] . .)) ([4,1] . .)) ([7,1] ([6,1] . .) ([8,1] . ([9,1] . .))))",
                    "([5,2] ([3,2] ([1,1] ([0,2] . .) ([2,1] . .)) ([4,1] . .)) ([7,1] ([6,1] . .) ([8,1] . ([9,1] . .))))",
                    "([5,2] ([3,2] ([1,1] ([0,2] . .) ([2,1] . .)) ([4,1] . .)) ([7,1] ([6,1] . .) ([8,1] . ([9,2] . .))))",
                "0,2 1,1 2,1 3,2 4,1 5,2 6,1 7,1 8,1 9,2 " },
                { "<empty tree>", "No Data" } };

        boolean error = false;
        for (int i = 0; i < tests.length; i++) {
            BinarySearchTree<String> tree = new BinarySearchTree<String>();
            for (int j = 0; j < tests[i].length; j++) {
                tree.incCount(tests[i][j]);
                String out = tree.dump();
                if (notest || out.compareTo(expected[i][j]) != 0)
                    error = true;
                if (dumpall)
                    System.out.println(out);
            }
            if (tests[i].length < 1) {
                String out = tree.dump();
                if (notest || out.compareTo(expected[i][0]) != 0)
                    error = true;
                if (dumpall)
                    System.out.println(out);
            }

            DataCount<String>[] cnt = tree.getCounts();
            String out = "";
            if (cnt != null && cnt.length > 0)
                for (int j = 0; j < cnt.length; j++)
                    out += cnt[j].data + "," + cnt[j].count + " ";
            else
                out = "No Data";
            if (notest
                    || out.compareTo(expected[i][expected[i].length - 1]) != 0)
                error = true;
            if (dumpall)
                System.out.println(out);
        }

        if (!notest) {
            if (error)
                System.out.println("Test failed!");
            else
                System.out.println("Test passed.");
        }
    }
}
