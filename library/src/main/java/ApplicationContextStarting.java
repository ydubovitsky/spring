import chapter.getters_setters.GetterSetterRobotImpl;
import chapter.params_order.ParamsOrderRobotImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import chapter.constructor.LiquidMetalRobotImpl;
import chapter.constructor.TerminatorRobotImpl;

public class ApplicationContextStarting {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

//*        Constructors examples start
        Object object = context.getBean("terminatorRobotImpl"); //! Тут используется конструктор
        if (object instanceof TerminatorRobotImpl) { //* Checking
            TerminatorRobotImpl terminatorRobotImpl = (TerminatorRobotImpl) context.getBean("terminatorRobotImpl");
            terminatorRobotImpl.purpose();
            terminatorRobotImpl.doAction();
        }

        LiquidMetalRobotImpl liquidMetalRobot = (LiquidMetalRobotImpl) context.getBean("liquidMetalRobotImpl"); //! Тут используются Getters and Setters и настройки в .xml property name="hand" ref="dellHand"...
        liquidMetalRobot.purpose();
        liquidMetalRobot.doAction();

//*        Getters and Setter example
        GetterSetterRobotImpl getterSetterRobot = (GetterSetterRobotImpl) context.getBean("getterSetterRobotImpl");
        getterSetterRobot.purpose();
        getterSetterRobot.doAction();

//*        Params in constructors and set params by setters
        ParamsOrderRobotImpl paramsOrderRobot = (ParamsOrderRobotImpl) context.getBean("paramsOrderRobotImpl");
        paramsOrderRobot.purpose();
        paramsOrderRobot.doAction();
    }
}
