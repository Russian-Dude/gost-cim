import ru.vniizht.model.result.CurrentFlow
import ru.vniizht.model.result.UserAttribute
import ru.vniizht.model.result.Voltage
import java.time.LocalDateTime
import java.util.*

/** Данные конечного устройства */
class EndDeviceInfo(
    /** Присущие устройству возможности (то есть функции, которые оно поддерживает) */
    val capability: EndDeviceCapability,
    /** Если TRUE, то твердотельное конечное устройство (в отличие от механического или электромеханического устройства) */
    val isSolidState: Boolean,
    /** Количество фаз, поддерживаемых конечным устройством, как правило, 0, 1 или 3 */
    val phaseCount: Int,
    /** Номинальный ток, А */
    val ratedCurrent: CurrentFlow,
    /** Номинальное напряжение, В */
    val ratedVoltage: Voltage,
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

/** Система автоматического регулирования */
open class RegulatingControl(
    /** Регулятор выключен (если присвоено значение "Ложь"; по умолчанию "включен") */
    val enabled: Boolean,
    /** Режим регулирования из заданного списка. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val mode: RegulatingControlModeKind,
    /** Оборудование, к которому относится система автоматического регулирования */
    val regulatingCondEq: Array<RegulatingCondEq>,
    /** Полюс оборудования, с которым ассоциируется система автоматического регулирования */
    val terminal: Terminal?,
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
) : PowerSystemResource

/** Параметры опыта холостого хода обмотки трансформатора */
class NoLoadTest(
    /** Потери холостого хода, кВт */
    val loss: Double,
    /** Ток холостого хода, % */
    val excitingCurrent: Double,
    /** Напряжение первичной обмотки, кВ */
    val energisedEndVoltage: Double,
    /** Вывод трансформатора, на который подается напряжение в опыте холостого хода */
    val energisedEnd: TransformerEndInfo?,
    override val basePower: Double,
    override val temperature: Double,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : TransformerTest

/** Зависимость допустимой длительности значения напряжения от его диапазона */
class rf_VoltageLimitDurationCurve(
    /** Оборудование, для которого задана допустимая длительность значения напряжения в зависимости от его диапазона */
    val rf_Equipments: Array<Equipment>,
    override val curveStyle: CurveStyle,
    override val xMultiplier: UnitMultiplier,
    override val xUnit: UnitSymbol,
    override val y1Multiplier: UnitMultiplier,
    override val y1Unit: UnitSymbol,
    override val y2Multiplier: UnitMultiplier,
    override val y2Unit: UnitSymbol,
    override val y3Multiplier: UnitMultiplier,
    override val y3Unit: UnitSymbol,
    override val curveDatas: Array<CurveData>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : Curve

/** Пропорциональная зависимость значения одного эксплуатационного ограничения/предела от значения другого исходного эксплуатационного ограничения/предела */
class LimitScalingLimit(
    /** Величина пропорциональной зависимости одного эксплуатационного ограничения/предела от исходного, % */
    val limitScalingPercent: Double,
    /** Исходный эксплуатационный предел, по отношению к которому определяется пропорциональная зависимость */
    val sourceOperationalLimit: OperationalLimit,
    override val equipment: Equipment?,
    override val operationalLimit: Array<OperationalLimit>,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : LimitDependency

/** Предоставляемая точка ICCP. Описание элементов информационного обмена по протоколу ICCP, которые предоставляются. Атрибут "name" должен иметь значение в обязательном порядке. Этот атрибут будет использован как параметр ICCP "DataValue" в процессе информационного обмена */
class ICCPProvidedPoint(
    /** Область применения. Показывает, является ли точка глобальной ("VCC") или доступной только стороне согласно таблице двухстороннего обмена ("ICC") */
    val scope: ICCPScopeKind,
    /** Тип точки доступа ICCP */
    val pointType: ICCPPointKind,
    /** Тип кодов качества точки доступа ICCP */
    val pointQuality: ICCPQualityKind,
    /** Права доступа точки ICCP */
    val accessPriviledge: ICCPAccessPrivilegeKind,
    override val iOPoint: IOPoint?,
    override val bilateralExchangeActor: BilateralExchangeActor,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : ProvidedBilateralPoint

/** Гидроэлектростанция */
class HydroPowerPlant(
    /** Тип гидроэлектростанции. Справочный класс профиля генерирующего оборудования в соответствии с приложением А */
    val hydroPlantStorageType: HydroPlantStorageKind,
    /** Установленная мощность гидроэлектростанции при номинальном напоре, МВт */
    val genRatedP: Double,
    /** Гидрогенераторы */
    val hydroGeneratingUnits: Array<HydroGeneratingUnit>,
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
) : PowerSystemResource

/** Технические параметры управляемых устройств продольной компенсации реактивной мощности */
class rf_SeriesVarCapacitorInfo(
    /** Мощность устройства продольной компенсации при форсировке, Мвар */
    val boostReactivePower: Double,
    /** Индуктивное сопротивление устройства продольной компенсации при форсировке, Ом */
    val boostX: Double,
    /** Допустимая длительность форсировки устройства продольной компенсации, с */
    val boosrMaxTime: Double,
    /** Уставка срабатывания по току схемы шунтирования, о.е. */
    val bypassCurrentThreshold: Double,
    /** Время изменения нагрузки между границами регулировочного диапазона, с */
    val ratedRegulatingTime: Double,
    /** Максимальная реактивная мощность, Мвар */
    val maxReactivePower: Double,
    /** Минимальная реактивная мощность, Мвар */
    val minReactivePower: Double,
    capacitorsInChainCount: Int,
    capacitorsInChainType: String,
    chainCapacitorsCount: Int,
    ratedCapacitance: Double,
    loss: Double,
    maxVoltage: Double,
    ratedCurrent: Double,
    ratedReactivePower: Double,
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
) : rf_SeriesCapacitorInfo(
    capacitorsInChainCount = capacitorsInChainCount,
    capacitorsInChainType = capacitorsInChainType,
    chainCapacitorsCount = chainCapacitorsCount,
    ratedCapacitance = ratedCapacitance,
    loss = loss,
    maxVoltage = maxVoltage,
    ratedCurrent = ratedCurrent,
    ratedReactivePower = ratedReactivePower,
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

/** Элемент схемы, который служит для размещения произвольного текста в заданном пространстве или текста, описывающего связанный элемент схемы */
class TextDiagramObject(
    /** Текст */
    val text: String,
    drawingOrder: Int,
    isPolygon: Boolean,
    offsetX: Double,
    offsetY: Double,
    rotation: Double,
    identifiedObject: IdentifiedObject?,
    diagram: Diagram,
    visibilityLayers: Array<VisibilityLayer>,
    diagramObjectPoints: Array<DiagramObjectPoint>,
    diagramObjectStyle: DiagramObjectStyle?,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : DiagramObject(
    drawingOrder = drawingOrder,
    isPolygon = isPolygon,
    offsetX = offsetX,
    offsetY = offsetY,
    rotation = rotation,
    identifiedObject = identifiedObject,
    diagram = diagram,
    visibilityLayers = visibilityLayers,
    diagramObjectPoints = diagramObjectPoints,
    diagramObjectStyle = diagramObjectStyle,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Аварийное событие на ЛЭП */
class LineFault(
    occurredDateTime: LocalDateTime,
    rf_type: rf_FaultType,
    kind: PhaseConnectedFaultKind,
    phases: PhaseCode,
    faultyEquipment: Equipment?,
    outage: Outage?,
    rf_OperationEvents: Array<rf_PACSOperationEvent>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : Fault(
    occurredDateTime = occurredDateTime,
    rf_type = rf_type,
    kind = kind,
    phases = phases,
    faultyEquipment = faultyEquipment,
    outage = outage,
    rf_OperationEvents = rf_OperationEvents,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)