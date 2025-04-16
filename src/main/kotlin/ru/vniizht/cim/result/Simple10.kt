import ru.vniizht.model.result.ShieldGroundingKind
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Технические параметры кабеля с ленточным доводящим экраном */
class TapeShieldCableInfo(
    /** Процент перекрытия намотки ленточного проводящего экрана, % */
    val tapeLap: Double,
    /** Толщина ленты проводящего экрана кабеля, м */
    val tapeThickness: Double,
    constructionKind: CableConstructionKind,
    outerJacketKind: CableOuterJacketKind,
    diameterOverCore: Double,
    diameterOverInsulation: Double,
    diameterOverJacket: Double,
    diameterOverScreen: Double,
    rf_insulationEr: Double,
    rf_insulationErShield: Double,
    nominalTemperature: Double,
    rf_radialMoistureBarrierThicknes: Double,
    rf_shieldCrossSection: Double,
    rf_shieldGrounding: ShieldGroundingKind,
    rf_shieldIsTransposed: Boolean,
    rf_sheathThickness: Double,
    shieldMaterial: CableShieldMaterialKind,
    rf_underShieldScreenThickness: Double,
    insulated: Boolean,
    insulationMaterial: WireInsulationKind,
    material: WireMaterialKind,
    ratedCurrent: Double,
    coreRadius: Double,
    rf_crossSection: Double,
    insulationThickness: Double,
    radius: Double,
    rDC20: Double,
    sizeDescription: String,
    wirePhaseInfo: Array<WirePhaseInfo>,
    productAssetModel: ProductAssetModel?,
    assets: Array<Asset>,
    powerSystemResources: Array<PowerSystemResource>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : CableInfo(
    constructionKind = constructionKind,
    outerJacketKind = outerJacketKind,
    diameterOverCore = diameterOverCore,
    diameterOverInsulation = diameterOverInsulation,
    diameterOverJacket = diameterOverJacket,
    diameterOverScreen = diameterOverScreen,
    rf_insulationEr = rf_insulationEr,
    rf_insulationErShield = rf_insulationErShield,
    nominalTemperature = nominalTemperature,
    rf_radialMoistureBarrierThicknes = rf_radialMoistureBarrierThicknes,
    rf_shieldCrossSection = rf_shieldCrossSection,
    rf_shieldGrounding = rf_shieldGrounding,
    rf_shieldIsTransposed = rf_shieldIsTransposed,
    rf_sheathThickness = rf_sheathThickness,
    shieldMaterial = shieldMaterial,
    rf_underShieldScreenThickness = rf_underShieldScreenThickness,
    insulated = insulated,
    insulationMaterial = insulationMaterial,
    material = material,
    ratedCurrent = ratedCurrent,
    coreRadius = coreRadius,
    rf_crossSection = rf_crossSection,
    insulationThickness = insulationThickness,
    radius = radius,
    rDC20 = rDC20,
    sizeDescription = sizeDescription,
    wirePhaseInfo = wirePhaseInfo,
    productAssetModel = productAssetModel,
    assets = assets,
    powerSystemResources = powerSystemResources,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Технические параметры кабеля с экраном, состоящим из отдельных проводников */
class ConcentricNeutralCableInfo(
    /** Внешний диаметр концентрической нейтрали кабеля, м */
    val diameterOverNeutral: Double,
    /** Удельное сопротивление концентрической нейтрали кабеля постоянному току при температуре 20 °C, Ом/м */
    val neutralStrandRDC20: Double,
    constructionKind: CableConstructionKind,
    outerJacketKind: CableOuterJacketKind,
    diameterOverCore: Double,
    diameterOverInsulation: Double,
    diameterOverJacket: Double,
    diameterOverScreen: Double,
    rf_insulationEr: Double,
    rf_insulationErShield: Double,
    nominalTemperature: Double,
    rf_radialMoistureBarrierThicknes: Double,
    rf_shieldCrossSection: Double,
    rf_shieldGrounding: ShieldGroundingKind,
    rf_shieldIsTransposed: Boolean,
    rf_sheathThickness: Double,
    shieldMaterial: CableShieldMaterialKind,
    rf_underShieldScreenThickness: Double,
    insulated: Boolean,
    insulationMaterial: WireInsulationKind,
    material: WireMaterialKind,
    ratedCurrent: Double,
    coreRadius: Double,
    rf_crossSection: Double,
    insulationThickness: Double,
    radius: Double,
    rDC20: Double,
    sizeDescription: String,
    wirePhaseInfo: Array<WirePhaseInfo>,
    productAssetModel: ProductAssetModel?,
    assets: Array<Asset>,
    powerSystemResources: Array<PowerSystemResource>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : CableInfo(
    constructionKind = constructionKind,
    outerJacketKind = outerJacketKind,
    diameterOverCore = diameterOverCore,
    diameterOverInsulation = diameterOverInsulation,
    diameterOverJacket = diameterOverJacket,
    diameterOverScreen = diameterOverScreen,
    rf_insulationEr = rf_insulationEr,
    rf_insulationErShield = rf_insulationErShield,
    nominalTemperature = nominalTemperature,
    rf_radialMoistureBarrierThicknes = rf_radialMoistureBarrierThicknes,
    rf_shieldCrossSection = rf_shieldCrossSection,
    rf_shieldGrounding = rf_shieldGrounding,
    rf_shieldIsTransposed = rf_shieldIsTransposed,
    rf_sheathThickness = rf_sheathThickness,
    shieldMaterial = shieldMaterial,
    rf_underShieldScreenThickness = rf_underShieldScreenThickness,
    insulated = insulated,
    insulationMaterial = insulationMaterial,
    material = material,
    ratedCurrent = ratedCurrent,
    coreRadius = coreRadius,
    rf_crossSection = rf_crossSection,
    insulationThickness = insulationThickness,
    radius = radius,
    rDC20 = rDC20,
    sizeDescription = sizeDescription,
    wirePhaseInfo = wirePhaseInfo,
    productAssetModel = productAssetModel,
    assets = assets,
    powerSystemResources = powerSystemResources,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Компенсационная обмотка силового трансформатора */
class rf_StabilizingWinding(
    /** Номинальная полная мощность компенсационной обмотки, МВА */
    val ratedS: Double,
    /** Номинальное напряжение компенсационной обмотки, кВ */
    val ratedU: Double,
    /** Номинальный ток, А */
    val ratedCurrent: Double,
    /** Активное сопротивление прямой последовательности, Ом */
    val r: Double,
    /** Реактивное сопротивление прямой последовательности, Ом */
    val x: Double,
    /** Трансформатор, к которому относится компенсационная обмотка */
    val rf_PowerTransformer: PowerTransformer?,
    /** Технические параметры компенсационной обмотки трансформатора */
    val rf_TransformerEndInfo: TransformerEndInfo?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Технические параметры шунтирующих реакторов */
open class rf_ShuntReactorInfo(
    /** Энергоемкость резистора в нейтральном выводе (Только для ШР с резисторами в нейтральных выводах), Дж */
    val groundResistorEnergy: Double,
    /** Сопротивление резистора в нейтральном выводе (Только для ШР с резисторами в нейтральных выводах), Ом */
    val neutralResistance: Double,
    /** Длительность нахождения резистора в нейтральном выводе в цепи (Только для ШР с резисторами в нейтральных выводах), с */
    val neutralResistanceTime: Double,
    /** Номинальное напряжение нулевых выводов, кВ */
    val ratedNeutralVoltage: Double,
    /** Допустимое напряжение изоляции нулевых выводов, кВ */
    val ratedNeutralInsulationVoltage: Double,
    loss: Double,
    maxPowerLoss: Double,
    ratedReactivePower: Double,
    ratedCurrent: Double,
    ratedVoltage: Double,
    productAssetModel: ProductAssetModel?,
    assets: Array<Asset>,
    powerSystemResources: Array<PowerSystemResource>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : ShuntCompensatorInfo(
    loss = loss,
    maxPowerLoss = maxPowerLoss,
    ratedReactivePower = ratedReactivePower,
    ratedCurrent = ratedCurrent,
    ratedVoltage = ratedVoltage,
    productAssetModel = productAssetModel,
    assets = assets,
    powerSystemResources = powerSystemResources,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Технические параметры вывода трансформатора */
class TransformerEndInfo(
    /** Номинальное напряжение, кВ */
    val ratedU: Double,
    /** Номер вывода трансформатора. Вывод высшего напряжения должен иметь номер один */
    val endNumber: Int,
    /** Все опыты холостого хода, в которых вывод трансформатора был под напряжением */
    val energisedEndNoLoadTests: Array<NoLoadTest>,
    /** Компенсационные обмотки трансформатора, к которым относятся технические параметры обмотки */
    val rf_StabilizingWindings: Array<rf_StabilizingWinding>,
    /** Электрические параметры магнитопровода трансформатора, связанные с информацией о технических параметрах выводов трансформатора */
    val coreAdmittance: TransformerCoreAdmittance?,
    /** Выводы трансформаторов, которым принадлежат технические параметры */
    val rf_PowerTransformerEnd: Array<PowerTransformerEnd>,
    /** Все опыты короткого замыкания, в которых вывод трансформатора был под напряжением */
    val energisedEndShortCircuitTests: Array<ShortCircuitTest>,
    /** Все опыты короткого замыкания, в которых вывод трансформатора был заземлен */
    val groundedEndShortCircuitTests: Array<ShortCircuitTest>,
    /** Информация о конструкции трансформатора */
    val transformerTankInfo: TransformerTankInfo,
    /** Электрические параметры трансформатора по модели звезда, связанные с информацией о технических параметрах выводов трансформатора */
    val transformerStarImpedance: TransformerStarImpedance?,
    override val productAssetModel: ProductAssetModel?,
    override val assets: Array<Asset>,
    override val powerSystemResources: Array<PowerSystemResource>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : AssetInfo

/** Подробное описание типа значения показания */
class ReadingType(
    /** Накопления данных во времени */
    val accumulation: String,
    /** Агрегированные данные с отдельных конечных точек. В основном используется для определения математической операции, выполняемой над macroPeriod, но также может использоваться для описания атрибута данных, когда macroPeriod не определен */
    val aggregate: String,
    /** Аргумент, используемый для введения чисел в описание единицы измерения там, где они необходимы. Значение 0 в числителе и знаменателе означает, что неприменимо */
    val argument: RationalNumber,
    /** Измеряемый товар */
    val commodity: String,
    /** Уровень потребления */
    val consumptionTier: Int,
    /** Критический пиковый период */
    val cpp: Int,
    /** Валюта */
    val currency: Currency,
    /** Направление перетока */
    val flowDirection: String,
    /** Индикация "гармонической" или "интергармонической" основы для измерения. Значение 0 в числителе и знаменателе означает, что аргумент неприменим */
    val interharmonic: ReadingInterharmonic,
    /** Интересующий период времени, который отражает то, как показание просматривается или фиксируется в течение длительного периода времени */
    val macroPeriod: DateTimeInterval,
    /** Определяет, "что" измеряется, как уточнение commodity. В сочетании с unit обеспечивает детализацию единицы измерения */
    val measurementKind: String,
    /** Интервал измерения */
    val measuringPeriod: String,
    /** Фаза */
    val phases: PhaseCode,
    /** Временная зона тарифа (TOU) */
    val tou: Int,
    /** Единицы измерения */
    val unit: String,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Набор параметров осциллограммы. Класс предназначен для указания набора каналов осциллограмм, основного оборудования и его полюсов, в которых осуществляется измерение по каждому каналу, устройства РАС, обмоток измерительного трансформатора, которые осуществляют измерение по каждому каналу */
class rf_Oscillogram(
    /** Функции РАС, регистрирующие каналы данной осциллограммы. Ассоциация предназначена для указания функций РАС для набора параметров осциллограммы в случае, когда каналы осциллографирования не моделируются как отдельные объекты */
    val disturbanceRecorders: Array<rf_DisturbanceRecorder>,
    /** Каналы, включенные в набор параметров осциллограмм */
    val channels: Array<rf_OscillogramChannel>,
    /** Файлы осциллограмм, соответствующие набору параметров */
    val oscillogramInstances: Array<rf_OscillogramDocument>,
    override val address: String,
    override val communicationLinks: Array<CommunicationLink>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : rf_NonoperativeTechnologicalData

/** Типизированная роль организации по отношению к другим объектам информационной модели */
open class OrganisationRole(
    /** Объекты информационной модели, связанные с ролью организации. Ассоциация является расширением стандартной модели и используется на практике для указания ролей организаций в отношении к объектам информационной модели различного типа, а не только для моделей материальных объектов. Применяется в случаях, когда включение моделей материальных объектов в информационный обмен нецелесообразно либо они отсутствуют */
    val rf_Objects: Array<IdentifiedObject>,
    /** Организации, имеющие заданную роль */
    val organisation: Organisation?,
    /** События конфигурирования роли организации */
    val configurationEvents: Array<ConfigurationEvent>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Дискретный параметр, возможные значения которого ограничены определенным набором состояний */
class Discrete(
    /** Максимальное значение нормального диапазона допустимого значения для измерения */
    val maxValue: Int,
    /** Минимальное значение нормального диапазона допустимого значения для измерения */
    val minValue: Int,
    /** Нормальное измеренное значение, например, использованное в процентных расчетах */
    val normalValue: Int,
    /** Значения дискретных измерений */
    val discreteValues: Array<DiscreteValue>,
    /** Дискретные каналы осциллограмм, регистрирующие параметры в данной точке измерения */
    val statusChannels: Array<rf_StatusChannel>,
    override val analog: Any,
    override val discrete: Any,
    override val measurementType: String,
    override val phases: PhaseCode,
    override val unitMultiplier: UnitMultiplier,
    override val unitSymbol: UnitSymbol,
    override val terminal: ACDCTerminal?,
    override val powerSystemResource: PowerSystemResource?,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : Measurement

/** Технические параметры автоматического регулятора возбуждения */
class rf_ExcitationControlInfo(
    /** Версия программного обеспечения алгоритма автоматического регулятора возбуждения */
    val algorithmVersion: String,
    /** Коэффициент усиления по току статора для высокочастотных систем с компаундированием по току статора */
    val currentGainFactor: Double,
    /** Установленный коэффициент усиления по отклонению частоты напряжения */
    val frequencyGainFactor: Double,
    /** Максимальный коэффициент усиления по отклонению частоты напряжения */
    val frequencyMaxGainFactor: Double,
    /** Установленный коэффициент усиления по производной частоты напряжения */
    val frequencyGainFactorDerivative: Double,
    /** Максимальный коэффициент усиления по производной частоты напряжения */
    val frequencyMaxGainFactorDerivative: Double,
    /** Постоянная времени интегратора пропорционально-интегрально-дифференциального канала регулятора возбуждения в режиме автоматического регулирования напряжения, с */
    val piTimeConstant: Double,
    /** Установленный коэффициент усиления по производной тока ротора */
    val rotorCurrentGainFactorDerivative: Double,
    /** Максимальный коэффициент усиления по производной тока ротора */
    val rotorCurrentMaxGainFactorDerivative: Double,
    /** Установленный коэффициент усиления по напряжению */
    val voltageGainFactor: Double,
    /** Максимальный коэффициент усиления по напряжению */
    val voltageMaxGainFactor: Double,
    /** Установленный коэффициент усиления по производной напряжения */
    val voltageGainFactorDerivative: Double,
    /** Максимальный коэффициент усиления по производной напряжения */
    val voltageMaxGainFactorDerivative: Double,
    override val productAssetModel: ProductAssetModel?,
    override val assets: Array<Asset>,
    override val powerSystemResources: Array<PowerSystemResource>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : AssetInfo