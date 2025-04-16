import ru.vniizht.model.result.ShieldGroundingKind
import ru.vniizht.model.result.UserAttribute
import java.time.LocalDateTime
import java.util.*

/** Параметры внедрения оборудования */
class AssetDeployment(
    /** Даты изменения состояния объекта. Структурный класс данных профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением Б */
    val deploymentDate: DeploymentDate,
    /** Текущее состояние объекта. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val deploymentState: DeploymentStateKind,
    /** Тип объекта размещения. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val facilityKind: FacilityKind,
    /** Внедряемый объект */
    val asset: Asset?,
    /** Номинальное эксплуатационное напряжение внедряемого материального объекта */
    val baseVoltage: BaseVoltage?,
    /** Область применения трансформатора */
    val transformerApplication: TransformerApplicationKind,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Набор параметров файла ОМП. Класс предназначен для указания устройства РАС, определяющего параметры места повреждения для определенного оборудования */
class rf_FaultLocationData(
    /** Функция РАС, обладающая возможностью записи файлов ОМП, соответствующих данному набору параметров */
    val disturbanceRecorder: rf_DisturbanceRecorder?,
    /** Файлы результатов ОМП, соответствующие набору параметров */
    val faultLocationInstances: Array<rf_FaultLocationDocument>,
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

/** Используется для отчета о создании, изменении или удалении объекта или его конфигурирования */
class ConfigurationEvent(
    /** Дата и время, когда событие вступило или вступит в силу [Дата и Время] */
    val effectiveDateTime: LocalDateTime,
    /** Источник/инициатор модификации */
    val modifiedBy: String,
    /** Замечания в виде произвольного текста */
    val remark: String,
    createdDateTime: LocalDateTime,
    reason: String,
    severity: String,
    status: Status,
    type: String,
    assets: Array<Asset>,
    aliasName: String,
    description: String,
    mRID: UUID,
    name: String,
    names: Array<Name>,
    rf_OrganisationRoles: Array<OrganisationRole>,
    rf_CustomAttributes: Array<UserAttribute>,
    diagramObjects: Array<DiagramObject>
) : ActivityRecord(
    createdDateTime = createdDateTime,
    reason = reason,
    severity = severity,
    status = status,
    type = type,
    assets = assets,
    aliasName = aliasName,
    description = description,
    mRID = mRID,
    name = name,
    names = names,
    rf_OrganisationRoles = rf_OrganisationRoles,
    rf_CustomAttributes = rf_CustomAttributes,
    diagramObjects = diagramObjects
)

/** Таблица зависимости эксплуатационных ограничений/пределов от положения переключателя регулировочных ответвлений */
class rf_TapChangerDependentLimitTable(
    /** Переключатель регулировочных ответвлений обмотки, к которому относится таблица зависимости эксплуатационных ограничений/пределов */
    val rf_RatioTapChanger: Array<RatioTapChanger>,
    /** Строка таблицы зависимости эксплуатационных ограничений/пределов от положения переключателя регулировочных ответвлений */
    val rf_TapChangerDependentLimitPoints: Array<rf_TapChangerDependentLimitPoint>,
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

/** Коэффициент, применяемый в точке поставки */
class ServiceMultiplier(
    /** Вид коэффициента */
    val kind: ServiceMultiplierKind,
    /** Значение коэффициента */
    val value: Double,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Технические параметры проводников воздушной ЛЭП */
class OverheadWireInfo(
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
) : WireInfo(
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

/** Подробное описание качества значения показания, производимого конечным устройством или системой */
class ReadingQualityType(
    /** Высокоуровневая предметная область качества значения показания */
    val category: String,
    /** Более специфическая предметная область качества значения показания, как подвариант category */
    val subCategory: String,
    /** Идентификатор системы, заявившей о проблеме с данными или предоставившей комментарий к этим данным */
    val systemId: String,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Общие дополнительные технические параметры коммутационных аппаратов */
open class OldSwitchInfo(
    breakingCapacity: Double,
    ratedCurrent: Double,
    ratedInterruptingTime: Double,
    rf_ratedInTransitTime: Double,
    ratedVoltage: Double,
    isSinglePhase: Boolean,
    isUnganged: Boolean,
    rf_isUngangedControl: Boolean,
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
) : SwitchInfo(
    breakingCapacity = breakingCapacity,
    ratedCurrent = ratedCurrent,
    ratedInterruptingTime = ratedInterruptingTime,
    rf_ratedInTransitTime = rf_ratedInTransitTime,
    ratedVoltage = ratedVoltage,
    isSinglePhase = isSinglePhase,
    isUnganged = isUnganged,
    rf_isUngangedControl = rf_isUngangedControl,
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

/** Коэффициент, применяемый на приборе учета */
class MeterMultiplier(
    /** Вид коэффициента */
    val kind: MeterMultiplierKind,
    /** Значение коэффициента */
    val value: Double,
    override val aliasName: String,
    override val description: String,
    override val mRID: UUID,
    override val name: String,
    override val names: Array<Name>,
    override val rf_OrganisationRoles: Array<OrganisationRole>,
    override val rf_CustomAttributes: Array<UserAttribute>,
    override val diagramObjects: Array<DiagramObject>
) : IdentifiedObject

/** Технические параметры кабеля */
open class CableInfo(
    /** Тип конструкции кабеля. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val constructionKind: CableConstructionKind,
    /** Вид материала наружной оболочки. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val outerJacketKind: CableOuterJacketKind,
    /** Диаметр проводящей части, включая полупроводящие оболочки, не включая изолирующие слои, м */
    val diameterOverCore: Double,
    /** Диаметр изолирующей оболочки, исключая внешний экран, мм */
    val diameterOverInsulation: Double,
    /** Диаметр наружной оболочки кабеля, м */
    val diameterOverJacket: Double,
    /** Диаметр по полупроводящему экрану под проводящим экраном, м */
    val diameterOverScreen: Double,
    /** Относительная диэлектрическая проницаемость изоляции между жилой и экраном, о.е. */
    val rf_insulationEr: Double,
    /** Относительная диэлектрическая проницаемость изоляции экрана, о.е. */
    val rf_insulationErShield: Double,
    /** Длительно допустимая температура нагрева жил кабеля, °C */
    val nominalTemperature: Double,
    /** Толщина алюминиевой ленты для поперечной герметизации, м */
    val rf_radialMoistureBarrierThicknes: Double,
    /** Сечение экрана, м2 */
    val rf_shieldCrossSection: Double,
    /** Тип заземления экрана. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val rf_shieldGrounding: ShieldGroundingKind,
    /** Транспозиция экрана (присутствует, если присвоено значение "Истина") */
    val rf_shieldIsTransposed: Boolean,
    /** Толщина брони кабеля, м */
    val rf_sheathThickness: Double,
    /** Материал экрана кабеля. Справочный класс профиля информационной модели ЛЭП и электросетевого оборудования напряжением 110 - 750 кВ в соответствии с приложением А */
    val shieldMaterial: CableShieldMaterialKind,
    /** Толщина полупроводящего покрытия по внутренней стороне экрана, м */
    val rf_underShieldScreenThickness: Double,
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
) : WireInfo(
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