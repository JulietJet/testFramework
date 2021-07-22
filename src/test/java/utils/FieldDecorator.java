package utils;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

public class FieldDecorator extends DefaultFieldDecorator {


    public FieldDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }


    /**
     * Метод вызывается фабрикой для каждого поля в классе
     */
    @Override
    public Object decorate(ClassLoader classLoader, Field field) {
        Class<?> decoratedClass = getDecoratableClass(field);
        //если класс поля декорируемый
        if (decoratedClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }
            return createElement(classLoader, locator, decoratedClass);
        }
        return null;
    }

    /**
     * Создание элемента.
     * Находит WebElement и передает его в кастомный класс
     */
    protected <T> T createElement(ClassLoader loader, ElementLocator locator, Class<T> clas) {
        WebElement proxy = proxyForLocator(loader, locator);
        return createInstance(clas, proxy);
    }

    /**
     * Возвращает декорируемый класс поля,
     * либо null если класс не подходит для декоратора
     */
    private Class getDecoratableClass(Field field) {
        Class<?> clas = field.getType();
        try {
            clas.getConstructor(WebElement.class);
        } catch (Exception e) {
            return null;
        }
        return clas;
    }

    /**
     * Создает экземпляр класса,
     * вызывая конструктор с аргументом WebElement
     */
    private <T> T createInstance(Class<T> clas, WebElement element) {
        try {
            return (T) clas.getConstructor(WebElement.class).newInstance(element);
        } catch (Exception e) {
            throw new AssertionError("Web Element can't be represented as " + clas);
        }
    }

}
