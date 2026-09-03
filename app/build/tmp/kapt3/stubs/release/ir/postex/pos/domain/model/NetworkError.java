package ir.postex.pos.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lir/postex/pos/domain/model/NetworkError;", "", "Lir/postex/pos/domain/model/Error;", "(Ljava/lang/String;I)V", "REQUEST_TIMEOUT", "BAD_REQUEST", "UNAUTHORIZED", "FORBIDDEN", "NULL_RESPONSE", "TOO_MANY_REQUESTS", "NO_INTERNET", "SERVER_ERROR", "SERIALIZATION", "UNKNOWN", "app_release"})
public enum NetworkError implements ir.postex.pos.domain.model.Error {
    /*public static final*/ REQUEST_TIMEOUT /* = new REQUEST_TIMEOUT() */,
    /*public static final*/ BAD_REQUEST /* = new BAD_REQUEST() */,
    /*public static final*/ UNAUTHORIZED /* = new UNAUTHORIZED() */,
    /*public static final*/ FORBIDDEN /* = new FORBIDDEN() */,
    /*public static final*/ NULL_RESPONSE /* = new NULL_RESPONSE() */,
    /*public static final*/ TOO_MANY_REQUESTS /* = new TOO_MANY_REQUESTS() */,
    /*public static final*/ NO_INTERNET /* = new NO_INTERNET() */,
    /*public static final*/ SERVER_ERROR /* = new SERVER_ERROR() */,
    /*public static final*/ SERIALIZATION /* = new SERIALIZATION() */,
    /*public static final*/ UNKNOWN /* = new UNKNOWN() */;
    
    NetworkError() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<ir.postex.pos.domain.model.NetworkError> getEntries() {
        return null;
    }
}