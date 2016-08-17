/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.platform.engine.discovery;

import static org.junit.platform.commons.meta.API.Usage.Experimental;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.platform.commons.meta.API;
import org.junit.platform.engine.DiscoverySelector;

/**
 * A {@link DiscoverySelector} that selects a directory so that
 * {@link org.junit.platform.engine.TestEngine TestEngines}
 * can discover tests or containers based on directories in the
 * file system.
 *
 * @since 1.0
 * @see FileSelector
 * @see #getDirectory()
 * @see #getPath()
 * @see #getRawPath()
 */
@API(Experimental)
public class DirectorySelector implements DiscoverySelector {

	private final String path;

	DirectorySelector(String path) {
		this.path = path;
	}

	/**
	 * Get the selected directory as a {@link java.io.File}.
	 *
	 * @see #getPath()
	 * @see #getRawPath()
	 */
	public File getDirectory() {
		return new File(this.path);
	}

	/**
	 * Get the selected directory as a {@link java.nio.file.Path} using the
	 * {@linkplain FileSystems#getDefault default} {@link FileSystem}.
	 *
	 * @see #getFile()
	 * @see #getRawPath()
	 */
	public Path getPath() {
		return Paths.get(this.path);
	}

	/**
	 * Get the selected directory as a <em>raw path</em>.
	 *
	 * @see #getDirectory()
	 * @see #getPath()
	 */
	public String getRawPath() {
		return this.path;
	}

}