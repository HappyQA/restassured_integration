package test.configuration;

@org.aeonbits.owner.Config.Sources({"classpath:config.properties"})
public interface CredentialsFile extends org.aeonbits.owner.Config {

    @Key("TestKey")
    String testKey();
}
