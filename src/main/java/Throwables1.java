public class Throwables1 {
    static void emulateException(int type) throws RuntimeException, Exception, Throwable {
        switch (type) {
            case 0:
                throw new RuntimeException("R");
            case 1:
                throw new Exception("E");
            case 2:
                throw new Throwable("T");
        }
    }

    static void tryEmulateException(int type) throws RuntimeException, Exception, Throwable {
        try {
            emulateException(type);
        } catch (Exception e) {
            System.err.print(e.getLocalizedMessage());
        } finally {
            System.err.print("*");
        }
    }

    public static void main(java.lang.String[] args) {
        for (int type = 0; type <= 3; type++) {
            try {
                tryEmulateException(type);
                System.err.print("!");
            } catch (RuntimeException e) {
                System.err.print(e.getLocalizedMessage());
            } catch (Exception e) {
                System.err.print(e.getLocalizedMessage());
            } catch (Throwable e) {
                System.err.print(e.getLocalizedMessage());
            } finally {
                System.err.print("F");
            }
        }
    }
}
