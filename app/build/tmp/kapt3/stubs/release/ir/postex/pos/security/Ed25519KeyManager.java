package ir.postex.pos.security;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006\u00a8\u0006\u0011"}, d2 = {"Lir/postex/pos/security/Ed25519KeyManager;", "", "()V", "generateKeyPair", "Ljava/security/KeyPair;", "loadPrivateKey", "Ljava/security/PrivateKey;", "keyBytes", "", "loadPublicKey", "Ljava/security/PublicKey;", "publicKeyToBase64", "", "publicKey", "sign", "data", "privateKey", "app_release"})
public final class Ed25519KeyManager {
    @org.jetbrains.annotations.NotNull()
    public static final ir.postex.pos.security.Ed25519KeyManager INSTANCE = null;
    
    private Ed25519KeyManager() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.security.KeyPair generateKeyPair() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String publicKeyToBase64(@org.jetbrains.annotations.NotNull()
    java.security.PublicKey publicKey) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String sign(@org.jetbrains.annotations.NotNull()
    byte[] data, @org.jetbrains.annotations.NotNull()
    java.security.PrivateKey privateKey) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.security.PublicKey loadPublicKey(@org.jetbrains.annotations.NotNull()
    byte[] keyBytes) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.security.PrivateKey loadPrivateKey(@org.jetbrains.annotations.NotNull()
    byte[] keyBytes) {
        return null;
    }
}