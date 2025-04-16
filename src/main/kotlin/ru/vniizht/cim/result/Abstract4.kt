import java.time.LocalDateTime
import java.util.*

/** Базовый класс для удельных сопротивлений участка ЛЭП */
interface PerLengthImpedance : PerLengthLineParameter {
    /** Участки линии переменного тока, имеющие указанные удельные параметры */
    val aCLineSegments: Array<ACLineSegment>
    /** Сегменты участка линии переменного тока, имеющие указанные удельные параметры */
    val rf_ACLineSeriesSection: Array<rf_ACLineSeriesSection>
}

/** Функция, выполняемая конечным устройством, таким как прибор учета, коммуникационное оборудование, контроллеры и т.д. */
interface EndDeviceFunction : AssetFunction {
    /** TRUE, если функция включена */
    val enabled: Boolean
    /** Регистры величин, измеряемых функцией конечного устройства */
    val registers: Array<Register>
}

/** Динамические параметры вращающейся электрической машины */
interface RotatingMachineDynamics : DynamicsFunctionBlock {
    /** Постоянная инерции генератора, приведенная к его полной мощности, с */
    val inertia: Double
    /** Реактивное сопротивление рассеяния Xs, о.е. */
    val statorLeakageReactance: Double
}

/** Фазосдвигающий переключатель регулировочных ответвлений обмотки трансформатора */
interface PhaseTapChanger : TapChanger {
    /** Вывод силового трансформатора, к которому относится переключатель регулировочных ответвлений с поперечным регулированием */
    val transformerEnd: TransformerEnd?
}

/** Контейнер оборудования постоянного тока */
interface DCEquipmentContainer : EquipmentContainer

/** Линия постоянного тока */
interface DCLine : DCEquipmentContainer

/** Базовый полюс постоянного тока */
interface DCBaseTerminal : ACDCTerminal

/** Оборудование */
interface Equipment : PowerSystemResource {
    /** Повреждения первичного оборудования */
    val faults: Array<Fault>
    /** Аварийное событие, связанное с оборудованием */
    val outages: Array<Outage>
    /** Присвоенное значение "Истина" признак того, что оборудование находится в работе */
    val normallyInService: Boolean
    /** (агрегирование)
    Контейнер оборудования, к которому относится единица оборудования */
    val equipmentContainer: EquipmentContainer?
    /** Дополнительная ассоциация оборудования с другим контейнером. Например, выключатель и другое оборудование в ячейке могут быть ассоциированы с ЛЭП либо участок ЛЭП может быть ассоциирован с ячейками подстанций (подстанциями) */
    val additionalEquipmentContainer: Array<EquipmentContainer>
    /** Точки учета, относящиеся к данному оборудованию */
    val usagePoints: Array<UsagePoint>
    /** Зависимости эксплуатационных ограничений/пределов */
    val limitDependencyModel: Array<LimitDependency>
    /** Набор эксплуатационных ограничений/пределов оборудования */
    val operationalLimitSet: Array<OperationalLimitSet>
    /** Допустимая длительность значения напряжения в зависимости от его диапазона */
    val rf_VoltageLimitDurationCurve: rf_VoltageLimitDurationCurve?
}

/** Нелинейный фазосдвигающий переключатель регулировочных ответвлений обмотки трансформатора */
interface PhaseTapChangerNonLinear : PhaseTapChanger {
    /** Шаг по напряжению при переключении на смежное ответвление, в процентах от номинального напряжения вывода силового трансформатора, % */
    val voltageStepIncrement: Double
    /** Максимальное индуктивное сопротивление луча звезды, Ом. Зависимость значения от номера регулировочного ответвления U-образна. Указанное этим атрибутом значение характерно для двух крайних ответвлений: нижнего и верхнего */
    val xMax: Double
    /** Минимальное индуктивное сопротивление луча звезды, Ом. Зависимость значения от номера регулировочного ответвления U-образна. Указанное этим атрибутом значение характерно для двух крайних ответвлений: нижнего и верхнего */
    val xMin: Double
}

/** Энергоблок */
interface GeneratingUnit : Equipment {
    /** Генераторы, входящие в состав энергоблока */
    val rotatingMachine: RotatingMachine?
    /** Статизм регулятора скорости, % */
    val governorSCD: Double
    /** Верхний предел автоматического регулирования, МВт */
    val highControlLimit: Double
    /** Нижний предел автоматического регулирования, МВт */
    val lowControlLimit: Double
    /** Скорость снижения мощности турбины, МВт/с */
    val lowerRampRate: Double
    /** Технологический максимум, МВт */
    val maxOperatingP: Double
    /** Технологический минимум, МВт */
    val minOperatingP: Double
    /** Номинальная активная мощность энергоблока, МВт */
    val nominalP: Double
    /** Скорость увеличения мощности энергоблока, МВт/с */
    val raiseRampRate: Double
    /** Маховой момент агрегата (турбина и генератор), т·м2 */
    val rf_unitGD2: Double
}