/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
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

package org.kie.cloud.openshift.scenario.builder;

import java.util.HashMap;
import java.util.Map;

import org.kie.cloud.api.deployment.constants.DeploymentConstants;
import org.kie.cloud.api.scenario.KieServerWithExternalDatabaseScenario;
import org.kie.cloud.api.scenario.builder.KieServerWithExternalDatabaseScenarioBuilder;
import org.kie.cloud.openshift.constants.OpenShiftConstants;
import org.kie.cloud.openshift.constants.OpenShiftTemplateConstants;
import org.kie.cloud.openshift.deployment.external.ExternalDeployment.ExternalDeploymentID;
import org.kie.cloud.openshift.scenario.KieServerWithExternalDatabaseScenarioImpl;

public class KieServerWithExternalDatabaseScenarioBuilderImpl extends AbstractOpenshiftScenarioBuilderTemplates<KieServerWithExternalDatabaseScenario> implements KieServerWithExternalDatabaseScenarioBuilder {

    private final Map<String, String> envVariables = new HashMap<>();

    public KieServerWithExternalDatabaseScenarioBuilderImpl() {
        envVariables.put(OpenShiftTemplateConstants.CREDENTIALS_SECRET, DeploymentConstants.getAppCredentialsSecretName());
        envVariables.put(OpenShiftTemplateConstants.KIE_SERVER_HTTPS_SECRET, OpenShiftConstants.getKieApplicationSecretName());

        // TODO: Workaround until Maven repo with released artifacts is implemented
        envVariables.put(OpenShiftTemplateConstants.KIE_SERVER_MODE, "DEVELOPMENT");
    }

    @Override
    public KieServerWithExternalDatabaseScenario getDeploymentScenarioInstance() {
        return new KieServerWithExternalDatabaseScenarioImpl(envVariables);
    }

    @Override
    public KieServerWithExternalDatabaseScenarioBuilder withInternalMavenRepo(boolean waitForRunning) {
        setExternalDeployment(ExternalDeploymentID.MAVEN_REPOSITORY, waitForRunning);
        return this;
    }

    @Override
    public KieServerWithExternalDatabaseScenarioBuilder withKieServerId(String kieServerId) {
        envVariables.put(OpenShiftTemplateConstants.KIE_SERVER_ID, kieServerId);
        return this;
    }

    @Override
    public KieServerWithExternalDatabaseScenarioBuilder withContainerDeployment(String kieContainerDeployment) {
        throw new UnsupportedOperationException("Not supported for templates.");
    }

}
