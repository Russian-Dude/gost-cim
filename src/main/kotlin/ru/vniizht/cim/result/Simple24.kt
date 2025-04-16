import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Синхронная машина */
class SynchronousMachine(
    /** Первичный двигатель синхронного генератора */
    val primeMovers: Array<PrimeMover>,
    /** Активная мощность, потребляемая в режиме синхронного компенсатора, МВт */
    val condenserP: Double,
    /** Тип охлаждающего агента. Справочный класс профиля генерирующего оборудования в соответствии с приложением А */
    val coolantType: CoolantType,
    /** Нейтраль заземлена (если присвоено значение "Истина") */
    val earthing: Boolean,
    /** Активное сопротивление заземления нейтральной точки генератора в схеме звезда, Ом */
    val earthingStarPointR: Double,
    /** Реактивное сопротивление заземления нейтральной точки генератора в схеме звезда, Ом */
    val earthingStarPointX: Double,
    /** Верхний предел по реактивной мощности (паспортный параметр), Мвар */
    val maxQ: Double,
    /** Ограничение по максимальному напряжению, кВ */
    val maxU: Double,
    /** Нижний предел по реактивной мощности, Мвар */
    val minQ: Double,
    /** Ограничение по минимальному напряжению, кВ */
    val minU: Double,
    /** Текущий режим работы синхронной машины. Справочный класс профиля генерирующего оборудования в соответствии с приложением А */
    val operatingMode: SynchronousMachineOperatingMode,
    /** Активное сопротивление статора, Ом */
    val r: Double,
    /** Активное сопротивление нулевой последовательности, Ом */
    val r0: Double,
    /** Активное сопротивление обратной последовательности, Ом */
    val r2: Double,
    /** Режимы работы, в которых синхронная машина способна работать. Справочный класс профиля генерирующего оборудования в соответствии с приложением А */
    val type: SynchronousMachineKind,
    /** Реактивное сопротивление прямой последовательности схемы замещения для расчета токов короткого замыкания, Ом */
    val rf_x: Double,
    /** Реактивное сопротивление нулевой последовательности, Ом */
    val x0: Double,
    /** Реактивное сопротивление обратной последовательности, Ом */
    val x2: Double,
    /** Реактивное насыщенное сверхпереходное сопротивление по продольной оси Xd", о.е. */
    val satDirectSubtransX: Double,
    /** Система возбуждения синхронной машины */
    val rf_ExcitationSystem: Array<rf_ExcitationSystem>,
    /** P-Q диаграмма синхронной машины по умолчанию */
    val initialReactiveCapabilityCurve: ReactiveCapabilityCurve?,
    /** P-Q диаграммы синхронной машины */
    val reactiveCapabilityCurves: Array<ReactiveCapabilityCurve>,
    /** Динамические параметры синхронной машины */
    val synchronousMachineDynamics: SynchronousMachineDynamics?,
    override val generatingUnit: GeneratingUnit?,
    override val ratedPowerFactor: Double,
    override val ratedS: Double,
    override val ratedU: Double,
    override val regulatingControl: RegulatingControl?,
    override val protectionEquipments: Array<ProtectionEquipment>,
    override val baseVoltage: BaseVoltage?,
    override val terminals: Array<Terminal>,
    override val rf_isThreePhaseEquipment: Boolean,
    override val faults: Array<Fault>,
    override val outages: Array<Outage>,
    override val normallyInService: Boolean,
    override val equipmentContainer: EquipmentContainer?,
    override val additionalEquipmentContainer: Array<EquipmentContainer>,
    override val usagePoints: Array<UsagePoint>,
    override val limitDependencyModel: Array<LimitDependency>,
    override val operationalLimitSet: Array<OperationalLimitSet>,
    override val rf_VoltageLimitDurationCurve: rf_VoltageLimitDurationCurve?,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : RotatingMachine

/** Ветряная турбина */
class rf_WindTurbine(
    override val rf_AsynchronousMachine: AsynchronousMachine?,
    override val synchronousMachines: Array<SynchronousMachine>,
    override val rf_ratedPower: Double,
    override val rf_rotationSpeed: Double,
    override val rf_rotorGD2: Double,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : PrimeMover

/** Фазовращатель асимметричный. Фазовращатель асимметричный, изменяющий напряжение начального вывода. Фаза изменившегося коэффициента трансформации зависит как от модуля, так и от фазы вольтодобавки (измеренной по отношению к напряжению начального полюса) */
class PhaseTapChangerAsymmetrical(
    /** Угол, на который вектор напряжения вольтодобавки опережает напряжение вывода, к которому присоединен переключатель, град. Поперечное (несимметричное) регулирование задают значением 90°. */
    val windingConnectionAngle: Double,
    override val voltageStepIncrement: Double,
    override val xMax: Double,
    override val xMin: Double,
    override val transformerEnd: TransformerEnd?,
    override val controlEnabled: Boolean,
    override val highStep: Int,
    override val lowStep: Int,
    override val itcFlag: Boolean,
    override val neutralStep: Int,
    override val rf_neutralStepCount: Int,
    override val normalStep: Int,
    override val tapChangerControl: TapChangerControl?,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : PhaseTapChangerNonLinear

/** Ветроэлектрогенератор */
class WindGeneratingUnit(
    override val rotatingMachine: RotatingMachine?,
    override val governorSCD: Double,
    override val highControlLimit: Double,
    override val lowControlLimit: Double,
    override val lowerRampRate: Double,
    override val maxOperatingP: Double,
    override val minOperatingP: Double,
    override val nominalP: Double,
    override val raiseRampRate: Double,
    override val rf_unitGD2: Double,
    override val faults: Array<Fault>,
    override val outages: Array<Outage>,
    override val normallyInService: Boolean,
    override val equipmentContainer: EquipmentContainer?,
    override val additionalEquipmentContainer: Array<EquipmentContainer>,
    override val usagePoints: Array<UsagePoint>,
    override val limitDependencyModel: Array<LimitDependency>,
    override val operationalLimitSet: Array<OperationalLimitSet>,
    override val rf_VoltageLimitDurationCurve: rf_VoltageLimitDurationCurve?,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : GeneratingUnit

/** Пошаговое регулирование. Управляющий импульс по изменению уставки в формате "убавить-добавить" */
class RaiseLowerCommand(
    /** Набор именованных значений для воздействий, которые могут встретиться в данной команде */
    val valueAliasSet: ValueAliasSet?,
    override val maxValue: Double,
    override val minValue: Double,
    override val analogValue: AnalogValue,
    override val unitMultiplier: UnitMultiplier,
    override val unitSymbol: UnitSymbol,
    override val powerSystemResource: PowerSystemResource?,
    override val bilateralToIOPoint: Array<ProvidedBilateralPoint>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : AnalogControl

/** Устройство на базе силовой электроники для включения в сеть солнечных модулей, ветряных энергоустановок */
class PowerElectronicsConnection(
    /** Верхний предел по реактивной мощности преобразователя, Мвар */
    val maxQ: Double,
    /** Нижний предел по реактивной мощности преобразователя, Мвар */
    val minQ: Double,
    /** Номинальный коэффициент мощности */
    val rf_ratedPowerFactor: Double,
    /** Тип (марка) преобразователя */
    val rf_type: String,
    /** Номинальная полная мощность преобразователя, МВА */
    val ratedS: Double,
    /** Номинальное напряжение, кВ */
    val ratedU: Double,
    /** P-Q диаграмма для устройств на базе силовой электроники */
    val rf_PowerElectronicsReactiveCapabilityCurve: rf_PowerElectronicsReactiveCapabilityCurve?,
    /** Генерирующие единицы, накопители или устройства, подключенные к сети переменного тока с использованием силовой электроники */
    val powerElectronicsUnit: Array<PowerElectronicsUnit>,
    override val regulatingControl: RegulatingControl?,
    override val protectionEquipments: Array<ProtectionEquipment>,
    override val baseVoltage: BaseVoltage?,
    override val terminals: Array<Terminal>,
    override val rf_isThreePhaseEquipment: Boolean,
    override val faults: Array<Fault>,
    override val outages: Array<Outage>,
    override val normallyInService: Boolean,
    override val equipmentContainer: EquipmentContainer?,
    override val additionalEquipmentContainer: Array<EquipmentContainer>,
    override val usagePoints: Array<UsagePoint>,
    override val limitDependencyModel: Array<LimitDependency>,
    override val operationalLimitSet: Array<OperationalLimitSet>,
    override val rf_VoltageLimitDurationCurve: rf_VoltageLimitDurationCurve?,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : RegulatingCondEq

/** Функция РАС */
class rf_DisturbanceRecorder(
    /** Набор параметров файлов ОМП, которые создает функция РАС */
    val faultLocationData: rf_FaultLocationData?,
    /** Наборы параметров осциллограмм, каналы которых регистрируются данными функциями РАС. Ассоциация предназначена для указания функций РАС для набора параметров осциллограммы в случае, когда каналы осциллографирования не моделируются как отдельные объекты */
    val oscillograms: Array<rf_Oscillogram>,
    /** Каналы осциллограмм, регистрируемые данной функцией РАС */
    val channels: Array<rf_OscillogramChannel>,
    override val rf_algorithmVersion: String,
    override val conductingEquipments: Array<ConductingEquipment>,
    override val protectedSwitches: Array<ProtectedSwitch>,
    override val rf_SensorWindings: Array<rf_SensorWinding>,
    override val rf_OperationEvents: Array<rf_ProtectionOperationEvent>,
    override val faults: Array<Fault>,
    override val outages: Array<Outage>,
    override val normallyInService: Boolean,
    override val equipmentContainer: EquipmentContainer?,
    override val additionalEquipmentContainer: Array<EquipmentContainer>,
    override val usagePoints: Array<UsagePoint>,
    override val limitDependencyModel: Array<LimitDependency>,
    override val operationalLimitSet: Array<OperationalLimitSet>,
    override val rf_VoltageLimitDurationCurve: rf_VoltageLimitDurationCurve?,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : ProtectionEquipment

/** Гидрогенератор */
class HydroGeneratingUnit(
    /** Режимы работы, в которых гидроагрегат способен работать. Справочный класс профиля генерирующего оборудования в соответствии с приложением А */
    val energyConversionCapability: HydroEnergyConversionKind,
    /** Расход воды через турбину при выдаче номинальной мощности гидроагрегата и расчетном напоре, м3/с */
    val rf_normalWaterFlow: Double,
    /** Расчетный напор гидроагрегата, м */
    val rf_normalWaterLevel: Double,
    /** Гидроэлектростанция */
    val hydroPowerPlant: HydroPowerPlant?,
    override val rotatingMachine: RotatingMachine?,
    override val governorSCD: Double,
    override val highControlLimit: Double,
    override val lowControlLimit: Double,
    override val lowerRampRate: Double,
    override val maxOperatingP: Double,
    override val minOperatingP: Double,
    override val nominalP: Double,
    override val raiseRampRate: Double,
    override val rf_unitGD2: Double,
    override val faults: Array<Fault>,
    override val outages: Array<Outage>,
    override val normallyInService: Boolean,
    override val equipmentContainer: EquipmentContainer?,
    override val additionalEquipmentContainer: Array<EquipmentContainer>,
    override val usagePoints: Array<UsagePoint>,
    override val limitDependencyModel: Array<LimitDependency>,
    override val operationalLimitSet: Array<OperationalLimitSet>,
    override val rf_VoltageLimitDurationCurve: rf_VoltageLimitDurationCurve?,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : GeneratingUnit

/** Устройство заземления нейтрали для компенсации токов однофазных коротких замыканий */
open class EarthFaultCompensator(
    /** Активное сопротивление устройства компенсации токов однофазного замыкания на землю, Ом */
    val r: Double,
    override val protectionEquipments: Array<ProtectionEquipment>,
    override val baseVoltage: BaseVoltage?,
    override val terminals: Array<Terminal>,
    override val rf_isThreePhaseEquipment: Boolean,
    override val faults: Array<Fault>,
    override val outages: Array<Outage>,
    override val normallyInService: Boolean,
    override val equipmentContainer: EquipmentContainer?,
    override val additionalEquipmentContainer: Array<EquipmentContainer>,
    override val usagePoints: Array<UsagePoint>,
    override val limitDependencyModel: Array<LimitDependency>,
    override val operationalLimitSet: Array<OperationalLimitSet>,
    override val rf_VoltageLimitDurationCurve: rf_VoltageLimitDurationCurve?,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : ConductingEquipment

/** Продольное компенсирующее устройство */
class SeriesCompensator(
    /** Номинальный коэффициент связи (только для сдвоенных реакторов), о.е. */
    val rf_couplingCoefficient: Double,
    /** Реактивное сопротивление прямой последовательности, Ом */
    val x: Double,
    /** Реактивное сопротивление нулевой последовательности, Ом */
    val x0: Double,
    /** Активное сопротивление прямой последовательности, Ом */
    val r: Double,
    /** Активное сопротивление нулевой последовательности, Ом */
    val r0: Double,
    override val protectionEquipments: Array<ProtectionEquipment>,
    override val baseVoltage: BaseVoltage?,
    override val terminals: Array<Terminal>,
    override val rf_isThreePhaseEquipment: Boolean,
    override val faults: Array<Fault>,
    override val outages: Array<Outage>,
    override val normallyInService: Boolean,
    override val equipmentContainer: EquipmentContainer?,
    override val additionalEquipmentContainer: Array<EquipmentContainer>,
    override val usagePoints: Array<UsagePoint>,
    override val limitDependencyModel: Array<LimitDependency>,
    override val operationalLimitSet: Array<OperationalLimitSet>,
    override val rf_VoltageLimitDurationCurve: rf_VoltageLimitDurationCurve?,
    override val assets: Array<Asset>,
    override val pSRType: PSRType?,
    override val measurements: Array<Measurement>,
    override val location: Location?,
    override val assetDatasheet: AssetInfo?,
    override val controls: Array<Control>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : ConductingEquipment