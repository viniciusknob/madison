package br.com.madison.rule;

/**
 * Copyright (C) 2013 Vinicius Knob
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
public abstract class Rule {

	private String _descriptionError;

	protected void setDescriptionError(String descriptionError) {
		_descriptionError = descriptionError;
	}

	public String descriptionError() {
		return _descriptionError;
	}

	public abstract boolean check();

}
