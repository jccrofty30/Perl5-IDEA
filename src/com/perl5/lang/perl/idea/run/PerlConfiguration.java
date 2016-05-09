/*
 * Copyright 2015 Alexandr Evstigneev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.perl5.lang.perl.idea.run;

import com.intellij.execution.CommonProgramRunConfigurationParameters;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.LocatableConfigurationBase;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.DefaultJDOMExternalizer;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.perl5.lang.perl.idea.run.debugger.PerlDebugProfileState;
import org.apache.commons.lang.StringUtils;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author VISTALL
 * @since 16-Sep-15
 */
public class PerlConfiguration extends LocatableConfigurationBase implements CommonProgramRunConfigurationParameters
{
	public String SCRIPT_PATH;
	public String PROGRAM_PARAMETERS;
	public String PERL_PARAMETERS;
	public String WORKING_DIRECTORY;
	public Map<String, String> ENV = new HashMap<String, String>();
	public boolean PASS_PARENT_ENVS = true;
	public String CHARSET;
	public boolean USE_ALTERNATIVE_SDK;
	public String ALTERNATIVE_SDK_PATH;

	public PerlConfiguration(Project project, @NotNull ConfigurationFactory factory, String name)
	{
		super(project, factory, name);
	}

	@Override
	public void readExternal(Element element) throws InvalidDataException
	{
		super.readExternal(element);
		DefaultJDOMExternalizer.readExternal(this, element);
	}

	@Override
	public void writeExternal(Element element) throws WriteExternalException
	{
		super.writeExternal(element);
		DefaultJDOMExternalizer.writeExternal(this, element);
	}

	@NotNull
	@Override
	public SettingsEditor<? extends RunConfiguration> getConfigurationEditor()
	{
		return new PerlConfigurationEditor(getProject());
	}

	@Nullable
	@Override
	public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment executionEnvironment) throws ExecutionException
	{
		if (executor instanceof DefaultDebugExecutor)
		{
			return new PerlDebugProfileState(executionEnvironment);
		}
		return new PerlRunProfileState(executionEnvironment);
	}

	@Override
	public String suggestedName()
	{
		VirtualFile scriptFile = getScriptFile();
		return scriptFile == null ? null : scriptFile.getName();
	}

	@Nullable
	public VirtualFile getScriptFile()
	{
		return StringUtils.isEmpty(SCRIPT_PATH) ? null : LocalFileSystem.getInstance().findFileByPath(SCRIPT_PATH);
	}

	public String getCharset()
	{
		return CHARSET;
	}

	public void setCharset(String charset)
	{
		CHARSET = charset;
	}

	public String getScriptPath()
	{
		return SCRIPT_PATH;
	}

	public void setScriptPath(String scriptPath)
	{
		SCRIPT_PATH = scriptPath;
	}

	public String getAlternativeSdkPath()
	{
		return ALTERNATIVE_SDK_PATH;
	}

	public void setAlternativeSdkPath(String path)
	{
		this.ALTERNATIVE_SDK_PATH = path;
	}

	public boolean isUseAlternativeSdk()
	{
		return USE_ALTERNATIVE_SDK;
	}

	public void setUseAlternativeSdk(boolean value)
	{
		this.USE_ALTERNATIVE_SDK = value;
	}

	@Nullable
	@Override
	public String getProgramParameters()
	{
		return PROGRAM_PARAMETERS;
	}

	@Override
	public void setProgramParameters(@Nullable String s)
	{
		PROGRAM_PARAMETERS = s;
	}

	@Nullable
	@Override
	public String getWorkingDirectory()
	{
		return WORKING_DIRECTORY;
	}

	@Override
	public void setWorkingDirectory(@Nullable String s)
	{
		WORKING_DIRECTORY = s;
	}

	@NotNull
	@Override
	public Map<String, String> getEnvs()
	{
		return ENV;
	}

	@Override
	public void setEnvs(@NotNull Map<String, String> map)
	{
		ENV = map;
	}

	@Override
	public boolean isPassParentEnvs()
	{
		return PASS_PARENT_ENVS;
	}

	@Override
	public void setPassParentEnvs(boolean b)
	{
		PASS_PARENT_ENVS = b;
	}

	public String getPERL_PARAMETERS()
	{
		return PERL_PARAMETERS;
	}

	public void setPERL_PARAMETERS(String PERL_PARAMETERS)
	{
		this.PERL_PARAMETERS = PERL_PARAMETERS;
	}
}
