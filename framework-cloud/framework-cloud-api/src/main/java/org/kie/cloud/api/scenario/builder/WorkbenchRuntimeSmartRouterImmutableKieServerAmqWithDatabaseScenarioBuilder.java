/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.cloud.api.scenario.builder;

import org.kie.cloud.api.scenario.WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenario;
import org.kie.cloud.api.settings.GitSettings;
import org.kie.cloud.api.settings.LdapSettings;

public interface WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder extends
                                                                                             KieDeploymentScenarioBuilder<WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder, WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenario> {

    /**
     * Return setup builder with additional configuration of internal maven repo.
     *
     * Parameters will be used automatically
     *
     * @return Builder with configured internal maven repo.
     */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder withInternalMavenRepo();

    /**
     * @param kieServerId kie-server id
     * @return Builder with environment variable for kie-server id set to given id
     */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder withKieServerId(String kieServerId);

    /**
     * Return configured builder with Kie Container deployment.
     *
     * @param kieContainerDeployment Kie Container deployment.
     * @return Builder with configured Kie container deployment
     */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder withContainerDeployment(String kieContainerDeployment);

    /**
     * Return configured builder with Source location
     *
     * @param gitReference Repository reference (branch/tag). E.g. 'master'.
     * @param gitContextDir Repository context (location of pom file).
     * @return Builder
     */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder withSourceLocation(String gitReference, String gitContextDir);

    /**
     * Return configured builder with Source location
     *
     * @param gitReference Repository reference (branch/tag). E.g. 'master'.
     * @param gitContextDir Repository context (location of pom file).
     * @param artifactDirs Directories containing built kjars, separated by
     * commas. For example "usertask-project/target,signaltask-project/target".
     * @return Builder
     */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder withSourceLocation(String gitReference, String gitContextDir, String artifactDirs);

    /**
     * Return setup builder with additional configuration for SSO deployment.
     *
     * @return Builder
     */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder deploySso();

    /**
     * Return setup builder with configure Kie Server http hostname.
     *
     * @param hostname HTTP hostname for Kie Server
     * @return Builder
     */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder withHttpKieServerHostname(String hostname);

    /**
     * Return setup builder with configure Kie Server https hostname.
     *
     * @param hostname HTTPS hostname for Kie Server
     * @return Builder
     */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder withHttpsKieServerHostname(String hostname);

    /**
     * Return configured builder with enabled drools classes filter for Kie
     * server.
     *
     * @param droolsFilter set to true to enable drools classes filter.
     * @return Builder
     */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder withDroolsServerFilterClasses(boolean droolsFilter);

    /**
     * Return setup builder with additional configuration of internal ldap.
     *
     * Parameters will be used automatically
     *
     * @param ldapSettings configuration of LDAP represented by a class.
     * @return Builder with configured internal ldap.
     */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder withLdap(LdapSettings ldapSettings);

    /**
    *
    * Return setup builder with enabled external JMS signal queue.
    * @param queueJndiName Name of the external JMS signal queue.
    *
    * @return Builder
    */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder enableExternalJmsSignalQueue(String queueJndiName);

    /**
     * Return setup builder with additional GIT settings.
     *
     * @param gitSettings settings configuration of GIT
     * @return Builder
     */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder withGitSettings(GitSettings gitSettings);

    /**
     * Return setup builder with configured nio2.k8s file system for Business Central Monitoring image.
     * 
     * @param k8sFsEnabled set to "true" to enable k8s FS for Monitoring
     * @return Builder
     */
    WorkbenchRuntimeSmartRouterImmutableKieServerAmqWithDatabaseScenarioBuilder withMonitoringK8sFileSystem(boolean k8sFsEnabled);
}
