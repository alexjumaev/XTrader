<?xml version="1.0"?>
<globals>
    <#include "root://activities/common/common_globals.xml.ftl" />

    <global id="topOut" value="." />
    <global id="projectOut" value="." />
    <global id="srcOut" value="${srcDir}/${slashedPackageName(packageName)}" />

    <#include "root://activities/common/kotlin_globals.xml.ftl" />
</globals>