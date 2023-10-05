package step.learning.ioc;

import com.google.inject.Inject;
import jdk.jfr.Name;
import step.learning.ioc.services.hash.HashService;
import step.learning.ioc.services.random.RandomService;
import step.learning.ioc.services.random.RandomServiceV1;

import javax.inject.Named;

public class IocDemo {
    //@Inject
    //private HashService hashService;

    private final HashService digestService;

    private final HashService dsaService;

    private final RandomServiceV1 randomService;

    @Inject
    public IocDemo(@Named("Digest-Hash") HashService digestService,
                   @Named("DSA-Hash") HashService dsaService) {
        this.digestService = digestService;
        this.dsaService = dsaService;
        randomService = new RandomServiceV1();
    }

    public void run()
    {
        System.out.println("IoC Demo");
        System.out.println(digestService.hash("IoC Demo"));
        System.out.println(dsaService.hash("IoC Demo"));
        System.out.println("Random: " + randomService.randomHex(6));
    }
}

/*
IoC - Inversion of Control (інверсія управління)
Архітектурний патерн - шаблон побудови (організації) коду згідно з яким
управління створенням об'єктів делегується окремому модулю, який часто
називають інжектором або контейнером служб
Class1 = {dbContext = new().... } => Class1 {@Inject  dbContext ...... }
Class2 = {dbContext = new().... }  Class2 {@Inject  dbContext ...... }
Class3 = {Class2 = new().... }  Class2 {@Inject  Class2 ...... }

Через це IoC також називають DI (Dependency Injection !! не плутати з DIP
Dependency Inversion Principle)

Наявність IoC змінює підходи до організації структури у т.ч структури запуску,
поділяючи її на 2 етапи: налаштування служб(інжектора) та резолюція(Resolve)
об'єктів - побудови "дерева" залежностей і розв'язання його(які створювати
першими, які від них залежать і т.д)

Поширені системи IoC - Spring, Guice

private final HashService hashService;

    @Inject
    public IocDemo(HashService hashService) {
        this.hashService = hashService;
    }

    @Inject
    private HashService hashService2;

    @Inject @Named("Hash128") private HashService hashService128;
*/