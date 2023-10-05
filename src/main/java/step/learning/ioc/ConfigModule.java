package step.learning.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import step.learning.ioc.services.hash.HashService;
import step.learning.ioc.services.hash.Md5HashService;
import step.learning.ioc.services.hash.Sha1HashService;
import step.learning.ioc.services.hash.SHA256;

public class ConfigModule extends AbstractModule {
    @Override
    protected void configure()
    {
        bind(HashService.class).annotatedWith(Names.named("Digest-Hash")).to(Md5HashService.class);
        bind(HashService.class).annotatedWith(Names.named("DSA-Hash")).to(Sha1HashService.class);
        bind(HashService.class).to(SHA256.class);
    }
}
